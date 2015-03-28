/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import java.util.ArrayList;
import java.util.Iterator;
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
    
    private List<AbstractEntity> enemies;
    private List<List<AbstractEntity>> enemiesWaves;
    private List<AbstractEntity> missles;
    private static final EntityManager em = new EntityManager();

    private EntityManager() {
//        missles = new ArrayList<>();
        missles = new CopyOnWriteArrayList<>();
    }

    public static EntityManager getInstance() {
        return em;
    }
    
    public EntityManager(List<AbstractEntity> enemies) {
        this.enemies = enemies;
    }

    public List<AbstractEntity> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<AbstractEntity> enemies) {
        this.enemies = enemies;
    }

    public List<List<AbstractEntity>> getEnemiesWaves() {
        return enemiesWaves;
    }

    public void setEnemiesWaves(List<List<AbstractEntity>> enemiesWaves) {
        this.enemiesWaves = enemiesWaves;
    }
    
    public List<AbstractEntity> getWaveEnemies(int waveNum) {
        return enemiesWaves.get(waveNum);
    }
    
    public int getWaves() {
        return enemiesWaves.size();
    }

    public List<AbstractEntity> getMissles() {
        return missles;
    }

    public void setMissles(List<AbstractEntity> missles) {
        this.missles = missles;
    }
    
    public void addMissle(AbstractEntity missle) {
        missles.add(missle);
    }
    
    public boolean removeMissle(AbstractEntity missle) {
        SpritesLayer sl = (SpritesLayer) Scene.getInstance().
                getLayer(GameConditions.OBJECTS_LAYER_ID);
        sl.removeEntity(missle);
        return missles.remove(missle);
    }
    
    public void destroy(AbstractEntity entity) {
        enemies.remove(entity);
    }
}
