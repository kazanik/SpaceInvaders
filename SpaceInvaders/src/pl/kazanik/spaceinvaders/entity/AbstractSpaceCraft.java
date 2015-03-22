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
public abstract class AbstractSpaceCraft extends AbstractEntity {
    
    protected float health;
    protected float armor;

    protected AbstractSpaceCraft() {
    }

    protected AbstractSpaceCraft(float health, float speed, float armor, AbstractSprite sprite) {
        super(speed, sprite);
        this.health = health;
        this.armor = armor;
    }
    
    public abstract void attack();
    public abstract void die();
}
