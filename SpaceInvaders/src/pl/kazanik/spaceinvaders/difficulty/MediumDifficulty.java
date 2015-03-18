/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.difficulty;

/**
 *
 * @author kazanik
 */
public class MediumDifficulty extends AbstractDifficulty {
    
    @Override
    public int enemyWaves() {
        return 2;
    }

    @Override
    public int enemiesInWave() {
        return 20;
    }

    @Override
    public long enemyWaveIntervalMilis() {
        return 400;
    }
}
