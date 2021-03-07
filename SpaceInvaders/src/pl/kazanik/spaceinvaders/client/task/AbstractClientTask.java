/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.client.task;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import pl.kazanik.spaceinvaders.client.Client;
import pl.kazanik.spaceinvaders.client.SessionManager;

/**
 *
 * @author user
 */
public abstract class AbstractClientTask implements /*Runnable*/ Callable<Boolean> {
    
    protected char[] inStreamBuff;
    protected Exception error;
    // heartbeat / synch
    protected Socket serverSocket;
    //protected final Object gameLock;
    //protected final Object serverLock;
    protected final SessionManager session;
    protected final Client client;
    
    protected AbstractClientTask(SessionManager session, Socket serverSocket, 
            Object gameLock, Object serverLock, Client client) {
        this.serverSocket = serverSocket;
        //this.gameLock = gameLock;
        this.session = session;
        //this.serverLock = serverLock;
        this.client = client;
    }

    protected abstract void execute() throws /*Exception*/ IOException;

    public Exception getError() {
        return error;
    }
    
}
