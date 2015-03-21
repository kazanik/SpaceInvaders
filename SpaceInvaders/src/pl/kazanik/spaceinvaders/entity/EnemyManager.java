/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author kazanik
 */
public class EnemyManager {
    
    private List<AbstractEntity> enemies;
    private static final EnemyManager em = new EnemyManager();

    private EnemyManager() {
    }

    public static EnemyManager getInstance() {
        return em;
    }
    
    public EnemyManager(List<AbstractEntity> enemies) {
        this.enemies = enemies;
    }

    public List<AbstractEntity> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<AbstractEntity> enemies) {
        this.enemies = enemies;
    }
    
    public void destroy(AbstractEntity enemy) {
        Iterator<AbstractEntity> it = enemies.iterator();
        while(it.hasNext()) {
            if(it.next().equals(enemy))
                it.remove();
        }
    }
}
