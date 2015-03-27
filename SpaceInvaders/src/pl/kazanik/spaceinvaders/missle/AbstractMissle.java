/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.missle;

import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;

/**
 *
 * @author kazanik
 */
public abstract class AbstractMissle extends AbstractEntity {
    
    private int damage;
    private int direction;

    protected AbstractMissle() {
    }

    protected AbstractMissle(int damage, int direction, float speed, 
            int horizontalDirection, int verticalDirection, 
            AbstractSprite sprite) {
        super(speed, horizontalDirection, verticalDirection, sprite);
        this.damage = damage;
        this.direction = direction;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void spawn() {
        // not used
    }

    @Override
    public void collision() {
        
    }

}
