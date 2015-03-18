/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.util.List;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
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
    
    public GameLoop(GameCanvas canvas, List<AbstractEntity> enemies) {
        init(canvas, enemies);
    }
    
    public final void init(GameCanvas canvas, List<AbstractEntity> enemies) {
        gameLoopRunnable = new GameLoopRunnable(canvas, enemies);
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
