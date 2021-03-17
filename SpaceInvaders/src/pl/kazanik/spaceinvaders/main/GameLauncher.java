/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import pl.kazanik.spaceinvaders.client.Client;
import pl.kazanik.spaceinvaders.client.SessionManager;
import pl.kazanik.spaceinvaders.client.task.AbstractClientTask;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.settings.GameConditions;

/**
 *
 * @author kazanik
 */
public class GameLauncher implements Runnable {
    
    private GameManager gameManager;
    private SessionManager session;
    private InetAddress serverAddress;
    private AbstractClientTask synchRun, ioRun;
    private boolean running, inited;
    private int frames;
    private Object gameLock, serverLock;
    private Client client;
    private Socket serverSocket;
    private Lock socketInLock, socketOutLock;
    private boolean updateRunning, heartbeatRunning, inputRunning, outputRunning;
    
    public GameLauncher() {
        
    }
    
    public GameLauncher(SessionManager session, GameManager gameManager) {
        this.session = session;
        this.gameManager = gameManager;
        this.socketInLock = new ReentrantLock();
        this.socketOutLock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
            init();
            int max_frames = 2_000_000_000;
            while(inited && !(serverSocket.isClosed() || 
                    serverSocket.isInputShutdown() || serverSocket.isOutputShutdown())
                    && !client.getSocket().isClosed()) {
//                if(inited) {
//                running = true;
                try {
//                    System.out.println("gamelauncher 1");
                    frames++;
                    Thread.sleep(GameConditions.CLIENT_SYNCH_DELAY);
                    // synch
                    String inMessage = client.peekInMessage();
                    if(inMessage != null && !inMessage.isEmpty() && 
                            inMessage.startsWith(GameConditions.SERVER_MODE_RECEIVE)) {
                        client.pollInMessage();
                        String[] inMessageSplitArray = inMessage.split(
                                GameConditions.MESSAGE_FRAGMENT_SEPARATOR);
                        String serverOutMode = inMessageSplitArray[0];
                        String inSerEnts = inMessageSplitArray[1];
                        EntityManager.getInstance().deserializeEntities(inSerEnts);
                        System.out.println("client synch");
                    }
                    String serEnts = EntityManager.getInstance().serializeClientEntities();
                    String outMessage = GameConditions.SERVER_MODE_SEND + 
                            GameConditions.MESSAGE_FRAGMENT_SEPARATOR + serEnts;
                    client.pushOutMessage(outMessage);
//                    System.out.println("gamelauncher 2");
                    // io
                    // input
                    String inputLine = "";
                    try {
                        inputLine = client.readLine();
                    } catch(SocketTimeoutException te) {}
//                    System.out.println("gamelauncher 21");
                    if(inputLine != null && !inputLine.isEmpty()) {
                        client.pushInMessage(inputLine);
            //            System.out.println("in message: "+inputLine);
                        System.out.println("client input");
                    }
//                    System.out.println("gamelauncher 3");
                    // output
                    String outputLine = client.pollOutMessage();
                    if(outputLine != null) {
                        client.printLine(outputLine);
                        //System.out.println("out message: "+outputLine);
                        System.out.println("client output");
                    }
                    if(frames >= max_frames)
                        frames = 0;
//                    System.out.println("gamelauncher 4");
                } catch (InterruptedException ex) {
                    System.err.println("game launcher run: synch/heartbeat task exc "
                        + "catched, now try stop thread and close resources");
                    running = false;
                }
//                }
            }
            System.out.println("game launcher loop done");
        } catch (IOException e) {
            System.err.println("init server ioex");
//            running = false;
        } finally {
            try {
                if(running)
                    abort();
                client.closeStreams();
                client.closeSocket();
                if(serverSocket != null) {
                    serverSocket.close();
                    serverSocket = null;
                }
            } catch(IOException/*|InterruptedException*/ e) {
                System.err.println("ex closing client runnable resources");
            }
        }
    }
    
    public final boolean init() throws IOException {
        if(inited) {
            running = true;
            return true;
        }
        try {
        gameLock = new Object();
        serverLock = new Object();
        serverAddress = InetAddress.getLocalHost();
        serverSocket = new Socket(serverAddress, GameConditions.SERVER_PORT);
        serverSocket.setSoTimeout(20);
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        client = new Client("", serverSocket, new AtomicLong(System.currentTimeMillis()),
                in, out, socketInLock, socketOutLock);
        inited = true;
        gameManager.startGameLoop();
        return true;
        } catch(IOException ie) {
//            System.out.println("a");
            inited = false;
            return false;
        }
    }
    
    public void abort() throws IOException {
        System.out.println("abort");
        running = false;
        gameLock = null;
        serverLock = null;
        gameManager.abortGame();
        client.closeSocket();
        client.closeStreams();
    }

    public boolean isRunning() {
        return running;
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }
    
    public void nextFrame() {
        frames++;
    }

    public void setUpdateRunning(boolean updateRunning) {
        this.updateRunning = updateRunning;
    }

    public void setHeartbeatRunning(boolean heartbeatRunning) {
        this.heartbeatRunning = heartbeatRunning;
    }

    public void setInputRunning(boolean inputRunning) {
        this.inputRunning = inputRunning;
    }

    public void setOutputRunning(boolean outputRunning) {
        this.outputRunning = outputRunning;
    }
    
}
