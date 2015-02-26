/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.imodel;

/**
 *
 * @author kazanik
 */
public abstract class AbstractEntity {
    
    private float health;
    private float speed;
    private AbstractSprite sprite;

    protected abstract void move();
    protected abstract void born();
    protected abstract void die();
    
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
