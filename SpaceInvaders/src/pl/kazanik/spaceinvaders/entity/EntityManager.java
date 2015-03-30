/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import pl.kazanik.spaceinvaders.missle.Missle;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.scene.SpritesLayer;
import pl.kazanik.spaceinvaders.settings.GameConditions;

/**
 *
 * @author kazanik
 */
public class EntityManager {
    
    private List<AbstractSpaceCraft> enemies;
    private List<List<AbstractSpaceCraft>> enemiesWaves;
    private List<AbstractEntity> enemyMissles;
    private List<AbstractEntity> playerMissles;
    private static final EntityManager em = new EntityManager();

    private EntityManager() {
        this.enemyMissles = new CopyOnWriteArrayList<>();
        this.enemies = new CopyOnWriteArrayList<>();
        this.playerMissles = new CopyOnWriteArrayList<>();
    }

    public static EntityManager getInstance() {
        return em;
    }
    
    public EntityManager(List<AbstractSpaceCraft> enemies) {
        this.enemies = enemies;
    }

    public List<AbstractSpaceCraft> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<AbstractSpaceCraft> enemies) {
        this.enemies = enemies;
    }
    
    public void addEnemy(AbstractSpaceCraft enemy) {
        this.enemies.add(enemy);
    }

    public List<List<AbstractSpaceCraft>> getEnemiesWaves() {
        return enemiesWaves;
    }

    public void setEnemiesWaves(List<List<AbstractSpaceCraft>> enemiesWaves) {
        this.enemiesWaves = enemiesWaves;
    }
    
    public List<AbstractSpaceCraft> getWaveEnemies(int waveNum) {
        return enemiesWaves.get(waveNum);
    }
    
    public int getWaves() {
        return enemiesWaves.size();
    }

    public List<AbstractEntity> getEnemyMissles() {
        return enemyMissles;
    }

    public void setEnemyMissles(List<AbstractEntity> missles) {
        this.enemyMissles = missles;
    }
    
    public void addEnemyMissle(AbstractEntity missle) {
        enemyMissles.add(missle);
    }
    
    public boolean removeEnemyMissle(AbstractEntity missle) {
        SpritesLayer sl = (SpritesLayer) Scene.getInstance().
                getLayer(GameConditions.OBJECTS_LAYER_ID);
        boolean succeed1 = sl.removeEntity(missle);
        boolean succeed2 = enemyMissles.remove(missle);
        return succeed1 && succeed2;
    }

    public List<AbstractEntity> getPlayerMissles() {
        return playerMissles;
    }

    public void setPlayerMissles(List<AbstractEntity> playerMissles) {
        this.playerMissles = playerMissles;
    }
    
    public void addPlayerMissle(AbstractEntity missle) {
        playerMissles.add(missle);
    }
    
    public boolean removePlayerMissle(AbstractEntity missle) {
        SpritesLayer sl = (SpritesLayer) Scene.getInstance().
                getLayer(GameConditions.OBJECTS_LAYER_ID);
        boolean succeed1 = sl.removeEntity(missle);
        boolean succeed2 = playerMissles.remove(missle);
        return succeed1 && succeed2;
    }
    
    public void checkDestroyedCrafts() {
        for(AbstractSpaceCraft craft : enemies) {
            if(!craft.isAlive()) destroy(craft);
        }
    }
    
    public void checkDestroyedMissles() {
        for(AbstractEntity missle : enemyMissles) {
            Missle m = (Missle) missle;
            if(m.isDestroyed()) removeEnemyMissle(missle);
        }
        for(AbstractEntity missle : playerMissles) {
            Missle m = (Missle) missle;
            if(m.isDestroyed()) removePlayerMissle(missle);
        }
    }
    
    public boolean destroy(AbstractEntity entity) {
        SpritesLayer sl = (SpritesLayer) Scene.getInstance().
                getLayer(GameConditions.OBJECTS_LAYER_ID);
        boolean succeed1 = sl.removeEntity(entity);
        boolean succeed2 = enemies.remove(entity);
        return succeed1 && succeed2;
    }
}
