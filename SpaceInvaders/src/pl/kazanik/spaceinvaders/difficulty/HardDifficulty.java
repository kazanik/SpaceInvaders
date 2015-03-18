/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.difficulty;

/**
 *
 * @author kazanik
 */
public class HardDifficulty extends AbstractDifficulty {
    
    @Override
    public int enemyWaves() {
        return 3;
    }

    @Override
    public int enemiesInWave() {
        return 30;
    }

    @Override
    public long enemyWaveIntervalMilis() {
        return 300;
    }
}
