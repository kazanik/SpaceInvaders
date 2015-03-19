/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import pl.kazanik.spaceinvaders.sprite.AbstractSprite;

/**
 *
 * @author kazanik
 */
public abstract class AbstractEntity {
    
    protected float health;
    protected float speed;
    protected float armor;
    protected int lastMoveFrame = 0;
    protected AbstractSprite sprite;

    protected AbstractEntity() {
        health = 100f;
        speed = 1f;
        armor = 0f;
    }

    protected AbstractEntity(AbstractSprite sprite) {
        this.sprite = sprite;
        health = 100f;
        speed = 1f;
        armor = 0f;
    }

    protected AbstractEntity(float health, float speed, float armor, 
            AbstractSprite sprite) {
        this.health = health;
        this.speed = speed;
        this.armor = armor;
        this.sprite = sprite;
    }

    public abstract void move();
    public abstract void spawn();
    public abstract void die();
    public abstract void attack();
    
    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public AbstractSprite getSprite() {
        return sprite;
    }

    public void setSprite(AbstractSprite sprite) {
        this.sprite = sprite;
    }

    public int getLastMoveFrame() {
        return lastMoveFrame;
    }

    public void setLastMoveFrame(int lastMoveFrame) {
        this.lastMoveFrame = lastMoveFrame;
    }
    
}
