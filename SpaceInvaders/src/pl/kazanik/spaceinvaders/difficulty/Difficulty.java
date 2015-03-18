/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.difficulty;

/**
 *
 * @author kazanik
 */
public enum Difficulty {
    
    EASY(1,10,500),
    MEDIUM(2,20,400),
    HARD(3,30,300);
    
    public final int enemyWaves;
    public final int enemiesInWave;
    public final long enemyWaveIntervalMilis;
    
    private Difficulty(int enemyWaves, int enemiesInWave, long enemyWaveIntervalMilis) {
        this.enemyWaves = enemyWaves;
        this.enemiesInWave = enemiesInWave;
        this.enemyWaveIntervalMilis = enemyWaveIntervalMilis;
    }

    public int getEnemyWaves() {
        return enemyWaves;
    }

    public int getEnemiesInWave() {
        return enemiesInWave;
    }

    public long getEnemyWaveIntervalMilis() {
        return enemyWaveIntervalMilis;
    }
    
}
