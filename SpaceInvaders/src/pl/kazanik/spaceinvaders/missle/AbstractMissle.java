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

    protected AbstractMissle() {
    }

    protected AbstractMissle(int damage, float speed, AbstractSprite sprite) {
        super(speed, sprite);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void move() {
        
    }

    @Override
    public void spawn() {
        
    }

    @Override
    public void collision() {
        
    }
    
}
