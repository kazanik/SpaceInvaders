/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.thread;

import java.util.List;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.main.GameLoop;

/**
 *
 * @author kazanik
 */
public class EnemyRunnable implements Runnable {

    private GameLoop gameLoop;
    private EntityManager manager = EntityManager.getInstance();
    private int waveNum;

    public EnemyRunnable() {
    }

    public EnemyRunnable(GameLoop gameLoop, int waveNum) {
        this.gameLoop = gameLoop;
        this.waveNum = waveNum;
    }
    
    @Override
    public void run() {
        System.out.println("Enemy runnable");
        List<AbstractEntity> waveEnemies = manager.getWaveEnemies(waveNum);
//        while(gameLoop.isRunning()) {
            for(AbstractEntity enemy : waveEnemies) {
                if(gameLoop.isRunning()) enemy.spawn();
            }
//        }
            Thread.currentThread().interrupt();
    }
    
}
