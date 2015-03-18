/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.thread;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.main.GameCanvas;

/**
 *
 * @author kazanik
 */
public class GameLoopRunnable implements Runnable {

    private List<AbstractEntity> enemies;
    private GameCanvas canvas;
    private boolean running = true;
    private int frames = 0;
    
    public GameLoopRunnable() {
        
    }
    
    public GameLoopRunnable(GameCanvas canvas, List<AbstractEntity> enemies) {
        this.enemies = enemies;
        this.canvas = canvas;
    }
    
    @Override
    public void run() {
        int lastMoveFrame = 0;
        while(running) {
            long lastLoopTime = System.currentTimeMillis();
            long lastFrameTime = 0l;
            long abs = Math.abs(lastLoopTime-lastFrameTime);
            if(abs > GameConditions.REFRESH_RATE) {
                canvas.repaint();
                lastFrameTime = System.currentTimeMillis();
                frames++;
            }
            if(lastMoveFrame+50000 == frames) {
                for(AbstractEntity enemy : enemies) {
                    enemy.move();
                }
                lastMoveFrame = frames;
            }
        }
    }
    
}
