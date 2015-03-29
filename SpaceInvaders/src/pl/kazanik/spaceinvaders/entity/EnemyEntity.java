/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import pl.kazanik.spaceinvaders.missle.Missle;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;
import pl.kazanik.spaceinvaders.weapon.AbstractWeapon;

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

    public EnemyEntity(float health, float speed, float armor, long intervalMilis, 
            int horizontalDirection, int verticalDirection, AbstractSprite sprite) {
        super(health, speed, armor, horizontalDirection, verticalDirection, sprite);
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
        if(isAlive()) {
            float dy = getSprite().getY()+getSpeed();
            getSprite().setY(dy);
            if(dy >= GameConditions.SCENE_HEIGHT)
                destroy();
        }
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
    public void destroy() {
//        System.out.println("Enemy died");
//        EntityManager.getInstance().destroy(this);
        setAlive(false);
    }

    @Override
    public void attack() {
//        System.out.println("Enemy attack");
        if(isAlive()) {
            
        }
    }

    @Override
    public <T extends AbstractEntity> void collision(T other) {
//        return null;
        destroy();
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Float.floatToIntBits(getSprite().getX());
        hash = 43 * hash + Float.floatToIntBits(getSprite().getY());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        if (Float.floatToIntBits(this.getSprite().getX()) != Float.floatToIntBits(other.getSprite().getX())) {
            return false;
        }
        if (Float.floatToIntBits(this.getSprite().getY()) != Float.floatToIntBits(other.getSprite().getY())) {
            return false;
        }
        return true;
    }

}
