/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.thread;

import java.awt.Rectangle;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.EnemyEntity;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.main.GameCanvas;
import pl.kazanik.spaceinvaders.main.GameLoop;

/**
 *
 * @author kazanik
 */
public class GameLoopRunnable implements Runnable {

    private PlayerEntity player;
    private GameCanvas canvas;
    private EntityManager manager = EntityManager.getInstance();
    private GameLoop gameLoop;
    private boolean running = true;
    private int frames = 0;
    
    public GameLoopRunnable() {
        
    }
    
    public GameLoopRunnable(GameCanvas canvas, PlayerEntity player, GameLoop gameLoop) {
        this.canvas = canvas;
        this.player = player;
        this.gameLoop = gameLoop;
    }
    
    @Override
    public void run() {
        System.out.println("Update runnable");
        long lastFrameTime = 0l;
        long start = System.currentTimeMillis();
        gameloop:
        while(running) {
            // Scene
            try {
                Thread.sleep(GameConditions.REFRESH_RATE);
                canvas.repaint();
                frames++;
                lastFrameTime = System.currentTimeMillis();
            } catch (InterruptedException ex) {
                Logger.getLogger(GameLoopRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Missles
            for(AbstractEntity missle : manager.getMissles()) {
                missle.move();
                missle.setLastMoveFrame(frames);
            }
            //      Enemies
            for(AbstractEntity enemy : manager.getEnemies()) {
                EnemyEntity e = (EnemyEntity) enemy;
                if(System.currentTimeMillis()-start > e.getIntervalMilis()) {
                    enemy.move();
                    enemy.setLastMoveFrame(frames);
                }
            }
            //      Player
            player.doAction();
            player.setLastMoveFrame(frames);
            frames = (frames >= 2000000000) ? 0 : frames;
            //      Collision
            for(AbstractEntity enemy : manager.getEnemies()) {
                if(enemy.getSprite().collisionRect().intersects(player.getSprite().collisionRect())) {
                    gameLoop.abort();
                    break gameloop;
                }
            }
            
        }
    }
    
}
