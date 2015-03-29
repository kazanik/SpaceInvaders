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
    private int horizontalMoveDirection;
    private int verticalMoveDirection;
    private AbstractWeapon weapon;

    protected AbstractSpaceCraft() {
    }

    protected AbstractSpaceCraft(float health, float speed, float armor, 
            int horizontalMoveDirection, int verticalMoveDirection, 
            AbstractSprite sprite) {
        super(speed, horizontalMoveDirection, verticalMoveDirection, sprite);
        this.health = health;
        this.armor = armor;
        this.horizontalMoveDirection = horizontalMoveDirection;
        this.verticalMoveDirection = verticalMoveDirection;
    }
    
    protected AbstractSpaceCraft(float health, float speed, float armor, 
            int horizontalMoveDirection, int verticalMoveDirection, 
            AbstractWeapon weapon, AbstractSprite sprite) {
        super(speed, horizontalMoveDirection, verticalMoveDirection, sprite);
        this.health = health;
        this.armor = armor;
        this.horizontalMoveDirection = horizontalMoveDirection;
        this.verticalMoveDirection = verticalMoveDirection;
        this.weapon = weapon;
    }
    
    public abstract void attack();
    public abstract void destroy();

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

    public int getHorizontalMoveDirection() {
        return horizontalMoveDirection;
    }

    public void setHorizontalMoveDirection(int horizontalMoveDirection) {
        this.horizontalMoveDirection = horizontalMoveDirection;
    }

    public int getVerticalMoveDirection() {
        return verticalMoveDirection;
    }

    public void setVerticalMoveDirection(int verticalMoveDirection) {
        this.verticalMoveDirection = verticalMoveDirection;
    }

    public AbstractWeapon getWeapon() {
        return weapon;
    }

    public void setWeapon(AbstractWeapon weapon) {
        this.weapon = weapon;
    }
    
}
