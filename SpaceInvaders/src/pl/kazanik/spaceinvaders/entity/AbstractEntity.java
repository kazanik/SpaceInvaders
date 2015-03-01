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
    
    private float health = 1.0f;
    private float speed = 1.0f;
    private float armor;
    private AbstractSprite sprite;

    protected AbstractEntity() {
    }

    protected AbstractEntity(AbstractSprite sprite) {
        this.sprite = sprite;
    }

    protected AbstractEntity(float health, float speed, float armor, 
            AbstractSprite sprite) {
        this.health = health;
        this.speed = speed;
        this.armor = armor;
        this.sprite = sprite;
    }

    public abstract void move();
    public abstract void born();
    public abstract void die();
    
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

    public AbstractSprite getSprite() {
        return sprite;
    }

    public void setSprite(AbstractSprite sprite) {
        this.sprite = sprite;
    }
    
}
