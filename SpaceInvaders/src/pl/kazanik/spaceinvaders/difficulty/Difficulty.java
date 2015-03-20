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
    
    EASY(1,10,500, 65000, 30000),
    MEDIUM(2,20,400, 45000, 45000),
    HARD(3,30,300, 30000, 50000);
    
    private final int enemyWaves;
    private final int enemiesInWave;
    private final long enemyWaveIntervalMilis;
    private final float enemySpeed;
    private final float playerSpeed;
    
    private Difficulty(int enemyWaves, int enemiesInWave, long enemyWaveIntervalMilis, 
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
