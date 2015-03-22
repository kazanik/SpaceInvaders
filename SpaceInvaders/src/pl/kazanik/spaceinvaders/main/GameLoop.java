/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.util.List;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.thread.CollisionRunnable;
import pl.kazanik.spaceinvaders.thread.EnemyRunnable;
import pl.kazanik.spaceinvaders.thread.GameLoopRunnable;
import pl.kazanik.spaceinvaders.thread.PlayerRunnable;

/**
 *
 * @author kazanik
 */
public class GameLoop {
    
    private GameCanvas canvas;
    private PlayerEntity player;
    private Thread updateThread, enemyThread, playerThread, collisionThread;
    private Runnable updateRunnable, enemyRunnable, playerRunnable, 
            collisionRunnable;
    private boolean running;
    private int frames;
    
    public GameLoop() {
        
    }
    
    public GameLoop(GameCanvas canvas, PlayerEntity player) {
        this.canvas = canvas;
        this.player = player;
    }
    
    public final void init() {
        updateRunnable = new GameLoopRunnable(canvas, player, this);
        updateThread = new Thread(updateRunnable);
        /*
        enemyRunnable = new EnemyRunnable(this);
        enemyThread = new Thread(enemyRunnable);
        playerRunnable = new PlayerRunnable(this, player);
        playerThread = new Thread(playerRunnable);
        collisionRunnable = new CollisionRunnable(this, player);
        collisionThread = new Thread(collisionRunnable);
        */
    }
    
    public void abort() {
        running = false;
        updateThread.interrupt();
//        enemyThread.interrupt();
//        playerThread.interrupt();
//        collisionThread.interrupt();
    }
    
    public void restart() {
        init();
        start();
    }
    
    public void start() {
        running = true;
        updateThread.start();
//        enemyThread.start();
//        playerThread.start();
//        collisionThread.start();
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
