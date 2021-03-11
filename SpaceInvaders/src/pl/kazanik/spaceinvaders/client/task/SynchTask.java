/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.client.task;

import java.io.IOException;
import java.net.Socket;
import pl.kazanik.spaceinvaders.client.Client;
import pl.kazanik.spaceinvaders.client.SessionManager;
import pl.kazanik.spaceinvaders.client.exception.ClientDisconnectedException;
import pl.kazanik.spaceinvaders.client.exception.ExceptionUtils;
import pl.kazanik.spaceinvaders.entity.AbstractSpaceCraft;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.main.GameLauncher;
import pl.kazanik.spaceinvaders.settings.GameConditions;

/**
 *
 * @author user
 */
public class SynchTask /*implements Runnable*/ extends AbstractClientTask {

    public SynchTask(SessionManager session, GameLauncher gameLauncher, 
            Client client) {
        super(session, gameLauncher, client);
    }

    @Override
    public Boolean call() throws IOException {
        try {
            execute();
            return true;
        } catch(IOException e) {
            gameLauncher.setUpdateRunning(false);
            String exLocation = "update task execute ioex";
            ClientDisconnectedException cde = new ClientDisconnectedException(
                session.getClientToken(), exLocation, e.getMessage(), e);
            error = cde;
            throw cde;
            //throw new RuntimeException("ex listening client heartbeat", e);
            //throw e;
        }
    }

    @Override
    protected void execute() throws IOException {
        boolean runn = true;
        while(runn) {
            try {
                Thread.sleep(GameConditions.CLIENT_SYNCH_DELAY);
                System.out.println("client synch");
                String inMessage = client.peekInMessage();
                EntityManager em = EntityManager.getInstance();
                if(inMessage != null && !inMessage.isEmpty() && 
                        inMessage.startsWith(GameConditions.SERVER_MODE_RECEIVE)) {
                    client.pollInMessage();
                    String[] inMessageSplitArray = inMessage.split(
                            GameConditions.MESSAGE_FRAGMENT_SEPARATOR);
                    String serverOutMode = inMessageSplitArray[0];
                    String inSerEnts = inMessageSplitArray[1];
                    em.deserializeEntities(inSerEnts);
                    client.setLastHeartBeat(System.currentTimeMillis());
                }
                String serEnts = em.serializeClientEntities();
                String outMessage = GameConditions.SERVER_MODE_SEND + 
                        GameConditions.MESSAGE_FRAGMENT_SEPARATOR + serEnts;
                client.pushOutMessage(outMessage);
            } catch(InterruptedException ex) {
                if(ExceptionUtils.isCausedByIOEx(ex)) {
                    System.out.println("****client update execute: "
                        + "update task exception catched, "
                        + "now try stop thread and close resources");
                    runn = false;
                } else {
                    System.out.println("so timeout");
                }
            }
        }
    }
    
}
