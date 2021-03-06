/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import java.util.ArrayList;
import java.util.List;
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
    private boolean alive = true;
    private int shots;      // missles fired
    private AbstractWeapon weapon;
    protected List<AbstractEntity> spacecraftMissles;

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
        spacecraftMissles = new ArrayList<>();
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
        spacecraftMissles = new ArrayList<>();
    }
    
    public abstract void attack();
    public abstract void destroy();
//    public abstract void move(int xOffset);

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

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }
    
    public List<AbstractEntity> getSpaceCraftMissles() {
        return spacecraftMissles;
    }
}
