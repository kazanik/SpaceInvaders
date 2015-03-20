/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.util.List;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
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
    
    public GameLoop(GameCanvas canvas, List<AbstractEntity> enemies, 
            PlayerEntity player) {
        init(canvas, enemies, player);
    }
    
    public final void init(GameCanvas canvas, List<AbstractEntity> enemies, 
            PlayerEntity player) {
        gameLoopRunnable = new GameLoopRunnable(canvas, enemies, player);
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
