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
    
    EASY(2, 15, 3500, 1, 16, "Easy"),
    MEDIUM(3, 30, 2500, 2, 8, "Medium"),
    HARD(4, 50, 1500, 3, 6, "Hard");
    
    private final int enemyWaves;
    private final int enemiesInWave;
    private final long enemyWaveIntervalMilis;
    private final float enemySpeed;
    private final float playerSpeed;
    private final String difficultyName;
    
    private Difficulties(int enemyWaves, int enemiesInWave, long enemyWaveIntervalMilis, 
            float enemySpeed, float playerSpeed, String difficultyName) {
        this.enemyWaves = enemyWaves;
        this.enemiesInWave = enemiesInWave;
        this.enemyWaveIntervalMilis = enemyWaveIntervalMilis;
        this.enemySpeed = enemySpeed;
        this.playerSpeed = playerSpeed;
        this.difficultyName = difficultyName;
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

    public String getDifficultyName() {
        return difficultyName;
    }
    
}
