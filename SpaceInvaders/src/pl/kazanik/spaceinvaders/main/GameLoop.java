/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.thread.GameLoopRunnable;

/**
 *
 * @author kazanik
 */
public class GameLoop {
    
    private GameCanvas canvas;
    private PlayerEntity player;
    private Thread updateThread;
    private Runnable updateRunnable;
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
    }
    
    public void abort() {
        running = false;
        updateThread.interrupt();
    }
    
    public void restart() {
        abort();
        init();
        start();
    }
    
    public void start() {
        running = true;
        updateThread.start();
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
