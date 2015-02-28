/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import pl.kazanik.spaceinvaders.thread.GameLoopRunnable;

/**
 *
 * @author kazanik
 */
public class GameLoop {
    
    private Thread gameLoopThread;
    private Runnable gameLoopRunnable;
    
    public GameLoop() {
        
    }
    
    public void init() {
        gameLoopRunnable = new GameLoopRunnable();
        gameLoopThread = new Thread(gameLoopRunnable);
    }
    
    public void abort() {
        
    }
    
    public void restart() {
        
    }
    
    public void start() {
        gameLoopThread.start();
    }
}
