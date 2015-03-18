/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.difficulty;

/**
 *
 * @author kazanik
 */
public abstract class AbstractDifficulty {
    
    public AbstractDifficulty() {
        
    }
    
    public abstract int enemyWaves();
    public abstract int enemiesInWave();
    public abstract long enemyWaveIntervalMilis();
}
