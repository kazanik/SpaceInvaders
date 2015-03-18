/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.difficulty;

/**
 *
 * @author kazanik
 */
public class EasyDifficulty extends AbstractDifficulty {

    @Override
    public int enemyWaves() {
        return 1;
    }

    @Override
    public int enemiesInWave() {
        return 10;
    }

    @Override
    public long enemyWaveIntervalMilis() {
        return 500;
    }
}
