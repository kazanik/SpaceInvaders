/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import pl.kazanik.spaceinvaders.sprite.AbstractSprite;
import pl.kazanik.spaceinvaders.weapon.AbstractWeapon;

/**
 *
 * @author kazanik
 */
public abstract class AbstractSpaceCraft extends AbstractEntity {
    
    private float health;
    private float armor;
    private AbstractWeapon weapon;

    protected AbstractSpaceCraft() {
    }

    protected AbstractSpaceCraft(float health, float speed, float armor, AbstractSprite sprite) {
        super(speed, sprite);
        this.health = health;
        this.armor = armor;
    }
    
    public abstract void attack();
    public abstract void die();

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }
    
}
