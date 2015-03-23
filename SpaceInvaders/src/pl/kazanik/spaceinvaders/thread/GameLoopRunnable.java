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
import pl.kazanik.spaceinvaders.entity.EnemyManager;
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
    private EnemyManager manager = EnemyManager.getInstance();
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
        gameloop:
        while(running) {
            long lastLoopTime = System.currentTimeMillis();
//            long lastFrameTime = 0l;
            // Paint
            long abs = Math.abs(lastLoopTime-lastFrameTime);
            if(abs >= GameConditions.REFRESH_RATE) {
                canvas.repaint();
                lastFrameTime = System.currentTimeMillis();
                frames++;
//                gameLoop.nextFrame();
            }
//            if(lastMoveFrame+50000 == frames) {
            //      Enemies
            for(AbstractEntity enemy : manager.getEnemies()) {
                if(enemy.getLastMoveFrame()+enemy.getSpeed() == frames) {
//                if(enemy.getLastMoveFrame()+enemy.getSpeed() == gameLoop.getFrames()) {
                    enemy.move();
                    enemy.setLastMoveFrame(frames);
//                    enemy.setLastMoveFrame(gameLoop.getFrames());
                }
            }
            
            //      Player
            if(player.getLastMoveFrame()+player.getSpeed() == frames) {
//            if(player.getLastMoveFrame()+player.getSpeed() == gameLoop.getFrames()) {
                player.updatePosition();
                player.setLastMoveFrame(frames);
//                player.setLastMoveFrame(gameLoop.getFrames());
            }
            
//                lastMoveFrame = frames;
//            }
            frames = (frames >= 2000000000) ? 0 : frames;
//            int frames = (gameLoop.getFrames() >= 2000000000) ? 0 : gameLoop.getFrames();
//            gameLoop.setFrames(frames);
            //      Collision
            for(AbstractEntity enemy : manager.getEnemies()) {
                Rectangle er = new Rectangle((int)enemy.getSprite().getX(), 
                        (int)enemy.getSprite().getY(), (int)enemy.getSprite().getWidth(), 
                        (int)enemy.getSprite().getHeight());
                Rectangle pr = new Rectangle((int)player.getSprite().getX(), 
                        (int)player.getSprite().getY(), (int)player.getSprite().getWidth(), 
                        (int)player.getSprite().getHeight());
                if(er.intersects(pr)) {     // collision
                    gameLoop.abort();
                    break gameloop;
                }
            }
            
        }
    }
    
}
