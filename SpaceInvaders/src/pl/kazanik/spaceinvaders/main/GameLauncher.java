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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import pl.kazanik.spaceinvaders.client.Client;
import pl.kazanik.spaceinvaders.client.task.HeartbeatTask;
import pl.kazanik.spaceinvaders.client.SessionManager;
import pl.kazanik.spaceinvaders.client.exception.ExceptionUtils;
import pl.kazanik.spaceinvaders.client.task.AbstractClientTask;
import pl.kazanik.spaceinvaders.client.task.InputListenerTask;
import pl.kazanik.spaceinvaders.client.task.OutputPrinterTask;
import pl.kazanik.spaceinvaders.client.task.SynchTask;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.thread.ClientGameLoop;

/**
 *
 * @author kazanik
 */
public class GameLauncher implements Runnable {
    
    private GameManager gameManager;
    private SessionManager session;
    private InetAddress serverAddress;
    private Thread gameThread;
    private Runnable gameRunnable;
    private boolean running, inited;
    private int frames;
    private Object gameLock, serverLock;
    private ExecutorService heartbeatPool, synchPool, inputPool, outputPool;
    private Client client;
    private Socket serverSocket;
    private Lock socketInLock, socketOutLock;
    
    public GameLauncher() {
        
    }
    
    public GameLauncher(SessionManager session, GameManager gameManager) {
        this.gameManager = gameManager;
        this.session = session;
        this.socketInLock = new ReentrantLock();
        this.socketOutLock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
//            init();
            int max_frames = 2_000_000_000;
            while(!init() || !(serverSocket.isClosed() || 
                    serverSocket.isInputShutdown() || serverSocket.isOutputShutdown())) {
                if(inited) {
//                running = true;
                try {
                    frames++;
                    Thread.sleep(GameConditions.CLIENT_SYNCH_DELAY);
                    //Thread.sleep(50);
                    AbstractClientTask synchTask = new SynchTask(
                        session, serverSocket, gameLock, serverLock, client);
                    AbstractClientTask heartbeatTask = new HeartbeatTask(
                        session, serverSocket, gameLock, serverLock, client);
                    AbstractClientTask inputListenerTask = new InputListenerTask(
                        session, serverSocket, gameLock, serverLock, client);
                    AbstractClientTask outputPrinterTask = new OutputPrinterTask(
                        session, serverSocket, gameLock, serverLock, client);
                    //if(frames%4 == 0) {
                        Future<?> futureHeart = heartbeatPool.submit(heartbeatTask);
                        futureHeart.get(100, TimeUnit.MICROSECONDS);
                    //}
                    //if(frames%2 == 0) {
                        Future<?> futureSynch = synchPool.submit(synchTask);
                        futureSynch.get(100, TimeUnit.MICROSECONDS);
                    //}
                    Future<?> futureInput = inputPool.submit(inputListenerTask);
                    futureInput.get(100, TimeUnit.MICROSECONDS);
                    Future<?> futureOutput = outputPool.submit(outputPrinterTask);
                    futureOutput.get(100, TimeUnit.MICROSECONDS);
                    if(frames >= max_frames)
                        frames = 0;
                    //System.out.println("blablabl");
                } catch (InterruptedException ex) {}
                catch(TimeoutException te) {}
                }
            }
            System.out.println("game launcher loop done");
        } catch (ExecutionException e) {
//            running = false;
            if(ExceptionUtils.isCausedByIOEx(e)) {
                System.err.println("game launcher run: synch/heartbeat task exc "
                    + "catched, now try stop thread and close resources");
            }
        } catch (IOException e) {
            System.err.println("init server ioex");
//            running = false;
        } finally {
            if(running)
                abort();
            try {
                client.closeStreams();
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
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        client = new Client("", serverSocket, System.currentTimeMillis(),
                in, out, socketInLock, socketOutLock);
        heartbeatPool = Executors.newCachedThreadPool();
        inputPool = Executors.newCachedThreadPool();
        outputPool = Executors.newCachedThreadPool();
        synchPool = Executors.newCachedThreadPool();
        gameManager.initGame();
//        gameRunnable = new ClientGameLoop(canvas, player, this);
        gameRunnable = new ClientGameLoop(gameManager.getCanvas(), gameManager.getPlayer());
        gameThread = new Thread(gameRunnable);
        inited = true;
        start();
        return true;
        } catch(IOException ie) {
//            System.out.println("a");
            inited = false;
            return false;
        }
    }
    
    public void abort() {
        System.out.println("abort");
        running = false;
        gameLock = null;
        serverLock = null;
        heartbeatPool.shutdownNow();
        inputPool.shutdownNow();
        outputPool.shutdownNow();
        synchPool.shutdownNow();
        
        if(gameThread != null)
            gameThread.interrupt();
        gameThread = null;
        
    }
    
    public void restart() throws IOException {
        abort();
        init();
        start();
    }
    
    public void start() {
        gameThread.start();
        running = true;
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
}
