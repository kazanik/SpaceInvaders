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
import pl.kazanik.spaceinvaders.main.GameLauncher;
import pl.kazanik.spaceinvaders.settings.GameConditions;

/**
 *
 * @author user
 */
public class OutputPrinterTask extends AbstractClientTask {

    public OutputPrinterTask(SessionManager session, GameLauncher gameLauncher, 
            Client client) {
        super(session, gameLauncher, client);
    }
    
    @Override
    protected void execute() throws IOException {
        while(gameLauncher.isRunning()) {
            try {
                Thread.sleep(GameConditions.CLIENT_SYNCH_DELAY);
                String outputLine = client.pollOutMessage();
                if(outputLine != null) {
                    client.printLine(outputLine);
                    //System.out.println("out message: "+outputLine);
                    System.out.println("client output");
                }
            } catch(InterruptedException ex) {
                if(ExceptionUtils.isCausedByIOEx(ex)) {
                    System.out.println("****client output execute: "
                        + "output task exception catched, "
                        + "now try stop thread and close resources");
                } else {
                    System.out.println("so timeout");
                }
            }
        }
    }

    @Override
    public void run() {
//    public Boolean call() throws Exception {
        try {
            execute();
//            return true;
        } catch(IOException e) {
            gameLauncher.setOutputRunning(false);
            try {
                gameLauncher.abort();
            } finally {
                String exLocation = "client output task execute ioex";
                ClientDisconnectedException cde = new ClientDisconnectedException(
                    session.getClientToken(), exLocation, e.getMessage(), e);
                error = cde;
    //            throw cde;
                throw new RuntimeException("ex listening client heartbeat", error);
                //throw e;
            }
        }
    }
    
}
