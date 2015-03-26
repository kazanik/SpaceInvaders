/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;

/**
 *
 * @author kazanik
 */

public class EnemyEntity extends AbstractSpaceCraft {

    private long intervalMilis;
    private boolean spawned = true;
    
    public EnemyEntity() {
        super();
    }

    public EnemyEntity(float health, float speed, float armor, 
            long intervalMilis, AbstractSprite sprite) {
        super(health, speed, armor, sprite);
        this.intervalMilis = intervalMilis;
    }

    public long getIntervalMilis() {
        return intervalMilis;
    }

    public boolean isSpawned() {
        return spawned;
    }

    @Override
    public void move() {
//        if(spawned)
//            spawn();
//        if(!spawned) {
            float dy = getSprite().getY()+getSpeed();
            getSprite().setY(dy);
            if(dy == GameConditions.SCENE_HEIGHT-getSprite().getHeight())
                die();
//        }
    }

    @Override
    public void spawn() {
//        System.out.println("Enemy born");
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() < start+intervalMilis) {
            
        }
        spawned = false;
    }

    @Override
    public void die() {
//        System.out.println("Enemy died");
    }

    @Override
    public void attack() {
//        System.out.println("Enemy attack");
    }

    @Override
    public void collision() {
        
    }
    
    @Override
    public int hashCode() {
        int hash = 4; //To change body of generated methods, choose Tools | Templates.
        hash = 13 * hash + (int) this.getSprite().getX();
        hash = 13 * hash + (int) this.getSprite().getY();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        final EnemyEntity other = (EnemyEntity) obj;
        if(this.getSprite().getX() != other.getSprite().getX()) {
            return false;
        }
        if(this.getSprite().getY() != other.getSprite().getY()) {
            return false;
        }
        return true; //To change body of generated methods, choose Tools | Templates.
    }

}
