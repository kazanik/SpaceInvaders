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

/**
 *
 * @author user
 */
public class OutputPrinterTask extends AbstractClientTask {

    public OutputPrinterTask(SessionManager session, Socket serverSocket, 
            Object gameLock, Object serverLock, Client client) {
        super(session, serverSocket, gameLock, serverLock, client);
    }
    
    @Override
    protected void execute() throws IOException {
        String outputLine = client.pollOutMessage();
        if(outputLine != null) {
            client.printLine(outputLine);
            //System.out.println("out message: "+outputLine);
        }
    }

    @Override
    public Boolean call() throws Exception {
        try {
            execute();
            return true;
        } catch(IOException e) {
            String exLocation = "listener task execute ioex";
            ClientDisconnectedException cde = new ClientDisconnectedException(
                session.getClientToken(), exLocation, e.getMessage(), e);
            error = cde;
            throw cde;
            //throw new RuntimeException("ex listening client heartbeat", e);
            //throw e;
        }
    }
    
}
