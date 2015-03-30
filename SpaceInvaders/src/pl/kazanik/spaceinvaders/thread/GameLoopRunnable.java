/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.thread;

import java.awt.Rectangle;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.AbstractSpaceCraft;
import pl.kazanik.spaceinvaders.entity.EnemyEntity;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.generator.EnemyGenerator;
import pl.kazanik.spaceinvaders.main.GameCanvas;
import pl.kazanik.spaceinvaders.main.GameLoop;
import pl.kazanik.spaceinvaders.missle.Missle;
import pl.kazanik.spaceinvaders.settings.GameSettings;

/**
 *
 * @author kazanik
 */
public class GameLoopRunnable implements Runnable {

    private PlayerEntity player;
    private GameCanvas canvas;
    private EntityManager em = EntityManager.getInstance();
    private GameLoop gameLoop;
    private GameSettings settings = GameSettings.getInstance();
    private EnemyGenerator eg = EnemyGenerator.getInstance();
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
        long lastCreateTime = System.currentTimeMillis();
//        PlayerEntity pe = (PlayerEntity) player;
        Random rnd = new Random();
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
            //      Enemy Missles move
            for(AbstractEntity missle : em.getEnemyMissles()) {
                missle.move();
                missle.setLastMoveFrame(frames);
            }
            //      Player Missles move
            for(AbstractEntity missle : em.getPlayerMissles()) {
                missle.move();
                missle.setLastMoveFrame(frames);
            }
            // Create enemies
            if(System.currentTimeMillis()-lastCreateTime > 
                    settings.getDifficulty().getEnemyWaveIntervalMilis()) {
                for (int i = 0; i < rnd.nextInt(4)+1; i++) {
                    AbstractSpaceCraft enemy = eg.generateEnemy();
                    em.addEnemy(enemy);
                }
                lastCreateTime = System.currentTimeMillis();
            }
            //      Enemies move
            for(AbstractSpaceCraft enemy : em.getEnemies()) {
//                EnemyEntity e = (EnemyEntity) enemy;
//                if(System.currentTimeMillis()-start > e.getIntervalMilis()) {
                    enemy.move();
                    enemy.setLastMoveFrame(frames);
//                }
            }
            //      Player actions
            player.doAction();
//            pe.doAction();
            player.setLastMoveFrame(frames);
            frames = (frames >= 2000000000) ? 0 : frames;
            //      Collision
            for(AbstractSpaceCraft enemy : em.getEnemies()) {
                if(enemy.getSprite().collisionRect().intersects(
                        player.getSprite().collisionRect())) {
                    gameLoop.abort();
                    break gameloop;
                }
                for(AbstractEntity missle : em.getEnemyMissles()) {
                    if(player.getSprite().collisionRect().intersects(
                            missle.getSprite().collisionRect())) {
                        gameLoop.abort();
                        break gameloop;
                    }
                    
                }
                for(AbstractEntity missle : em.getPlayerMissles()) {
                    if(enemy.getSprite().collisionRect().intersects(
                            missle.getSprite().collisionRect())) {
                        enemy.collision(missle);
                        missle.collision(enemy);
                    }
                }
            }
            em.checkDestroyedCrafts();
            em.checkDestroyedMissles();
        }
    }
    
}
