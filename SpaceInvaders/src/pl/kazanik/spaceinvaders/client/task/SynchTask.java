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
import pl.kazanik.spaceinvaders.entity.AbstractSpaceCraft;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.settings.GameConditions;

/**
 *
 * @author user
 */
public class SynchTask /*implements Runnable*/ extends AbstractClientTask {

    public SynchTask(SessionManager session, Socket serverSocket, 
            Object gameLock, Object serverLock, Client client) {
        super(session, serverSocket, gameLock, serverLock, client);
    }

    @Override
    public Boolean call() throws IOException {
        try {
            execute();
            return true;
        } catch(IOException e) {
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
            // find player by token
        }
        String serEnts = em.serializeClientEntities();
        String outMessage = GameConditions.SERVER_MODE_SEND + 
                GameConditions.MESSAGE_FRAGMENT_SEPARATOR + serEnts;
        client.pushOutMessage(outMessage);
    }
    
}
