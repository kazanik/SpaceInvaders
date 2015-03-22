/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.thread;

import java.awt.Rectangle;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.EnemyManager;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.main.GameLoop;

/**
 *
 * @author kazanik
 */
public class CollisionRunnable implements Runnable {

    private GameLoop gameLoop;
    private PlayerEntity player;
    private EnemyManager manager = EnemyManager.getInstance();

    public CollisionRunnable() {
    }

    public CollisionRunnable(GameLoop gameLoop, PlayerEntity player) {
        this.gameLoop = gameLoop;
        this.player = player;
    }
    
    @Override
    public void run() {
        System.out.println("Collision runnable");
        while(gameLoop.isRunning()) {
            for(AbstractEntity enemy : manager.getEnemies()) {
                Rectangle er = new Rectangle((int)enemy.getSprite().getX(), 
                        (int)enemy.getSprite().getY(), (int)enemy.getSprite().getWidth(), 
                        (int)enemy.getSprite().getHeight());
                Rectangle pr = new Rectangle((int)player.getSprite().getX(), 
                        (int)player.getSprite().getY(), (int)player.getSprite().getWidth(), 
                        (int)player.getSprite().getHeight());
                if(er.intersects(pr)) {     // collision
                    gameLoop.abort();
                }
            }
        }
    }
    
}
