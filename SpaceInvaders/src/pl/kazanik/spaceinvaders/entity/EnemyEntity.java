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
        float dy = getSprite().getY()+getSpeed();
        getSprite().setY(dy);
        if(dy >= GameConditions.SCENE_HEIGHT)
            destroy();
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
        System.out.println("Enemy died");
        EntityManager.getInstance().destroy(this);
    }

    @Override
    public void attack() {
//        System.out.println("Enemy attack");
    }

    @Override
    public <T extends AbstractEntity> void collision(T other) {
//        return null;
    }

}
