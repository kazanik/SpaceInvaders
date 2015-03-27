/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.difficulty;

/**
 *
 * @author kazanik
 */
public enum Difficulties {
    
//    EASY(2, 15, 3500, 24, 3),
//    MEDIUM(2, 30, 2500, 16, 4),
//    HARD(3, 50, 1500, 15, 5);
    EASY(2, 15, 3500, 1, 5),
    MEDIUM(2, 30, 2500, 2, 8),
    HARD(3, 50, 1500, 3, 6);
    
    private final int enemyWaves;
    private final int enemiesInWave;
    private final long enemyWaveIntervalMilis;
    private final float enemySpeed;
    private final float playerSpeed;
    
    private Difficulties(int enemyWaves, int enemiesInWave, long enemyWaveIntervalMilis, 
            float enemySpeed, float playerSpeed) {
        this.enemyWaves = enemyWaves;
        this.enemiesInWave = enemiesInWave;
        this.enemyWaveIntervalMilis = enemyWaveIntervalMilis;
        this.enemySpeed = enemySpeed;
        this.playerSpeed = playerSpeed;
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

    public float getEnemySpeed() {
        return enemySpeed;
    }

    public float getPlayerSpeed() {
        return playerSpeed;
    }
    
}
