/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.client.task;

import java.io.IOException;
import java.net.Socket;
import java.util.regex.Matcher;
import pl.kazanik.spaceinvaders.client.Client;
import pl.kazanik.spaceinvaders.client.SessionManager;
import pl.kazanik.spaceinvaders.client.exception.ClientDisconnectedException;
import pl.kazanik.spaceinvaders.settings.GameConditions;

/**
 *
 * @author user
 */
public class HeartbeatTask /*implements Runnable*/ extends AbstractClientTask {

    public HeartbeatTask(SessionManager session, Socket serverSocket, 
            Object gameLock, Object serverLock, Client client) {
        super(session, serverSocket, gameLock, serverLock, client);
    }
    
    @Override
    public Boolean call() throws IOException {
        try {
            execute();
            return true;
        } catch(IOException e) {
            String exLocation = "heartbeat task execute ioex";
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
        if(inMessage != null && !inMessage.isEmpty() && 
                inMessage.startsWith(GameConditions.SERVER_MODE_HEARTBEAT)) {
            client.pollInMessage();
            String[] inMessageSplitArray = inMessage.split(
                    GameConditions.MESSAGE_FRAGMENT_SEPARATOR);
            String inServerOutMode = inMessageSplitArray[0]; //1
            String inToken = inMessageSplitArray[1];
//            System.out.println("in token: "+inToken);
            if(!client.isTokenSaved())
                client.setToken(inToken);
            if(inServerOutMode != null && inToken != null) {
                Matcher tokenMatcher = GameConditions.TOKEN_PATTERN.matcher(inToken);
                if(tokenMatcher.matches())
                    session.setClientToken(inToken);
            }
            client.setLastHeartBeat(System.currentTimeMillis());
        }
        String outMessage = GameConditions.SERVER_MODE_HEARTBEAT +
            GameConditions.MESSAGE_FRAGMENT_SEPARATOR + session.getClientToken();
        client.pushOutMessage(outMessage);
    }
    
}
