/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.thread;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.AbstractSpaceCraft;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.generator.EnemyGenerator;
import pl.kazanik.spaceinvaders.main.GameCanvas;
import pl.kazanik.spaceinvaders.settings.GameSettings;
import pl.kazanik.spaceinvaders.sound.SoundPlayer;

/**
 *
 * @author kazanik
 */
public class ClientGameLoop implements Runnable {

    private PlayerEntity player;
    private GameCanvas canvas;
    private EntityManager em = EntityManager.getInstance();
    private GameSettings settings = GameSettings.getInstance();
    private EnemyGenerator eg = new EnemyGenerator();
    private SoundPlayer sp = new SoundPlayer();
    private boolean running = true;
    private int frames = 0;
    private int enemiesCreated = 0;
    
    public ClientGameLoop() {
        
    }
    
    public ClientGameLoop(GameCanvas canvas, PlayerEntity player) {
        this.canvas = canvas;
        this.player = player;
    }
    
    @Override
    public void run() {
        System.out.println("Update runnable");
        long lastFrameTime = 0l;
        long lastCreateTime = System.currentTimeMillis();
        Random rnd = new Random();
        gameloop:
        while(running) {
            // Scene
            try {
                Thread.sleep(GameConditions.SCENE_REFRESH_RATE);
                canvas.repaint();
                frames++;
                lastFrameTime = System.currentTimeMillis();
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientGameLoop.class.getName()).log(Level.SEVERE, null, ex);
                running = false;
                break;
            }
            //      Player Missles move
            for(AbstractEntity missle : em.getPlayerMissles()) {
                missle.move();
                missle.setLastMoveFrame(frames);
            }
            //      Player actions
            player.doAction();
            player.setLastMoveFrame(frames);
            frames = (frames >= 2000000000) ? 0 : frames;
            //      Collisions
            for(AbstractSpaceCraft enemy : em.getEnemies()) {
                if(enemy.getSprite().collisionRect().intersects(
                        player.getSprite().collisionRect())) {
//                    gameLoop.abort();
                    break gameloop;
                }
                for(AbstractEntity missle : em.getEnemyMissles()) {
                    if(player.getSprite().collisionRect().intersects(
                            missle.getSprite().collisionRect())) {
//                        gameLoop.abort();
                        break gameloop;
                    }
                }
                for(AbstractEntity missle : em.getPlayerMissles()) {
                    if(enemy.getSprite().collisionRect().intersects(
                            missle.getSprite().collisionRect())) {
                        enemy.collision(missle);
                        missle.collision(enemy);
                        //
                        sp.play(GameConditions.EXPLOSION_SOUND_PATH);
                    }
                }
            }
            em.checkDestroyedCrafts();
            em.checkDestroyedMissles();
        }
    }
    
}
