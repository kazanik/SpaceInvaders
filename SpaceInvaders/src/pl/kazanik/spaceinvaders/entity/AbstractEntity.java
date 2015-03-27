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
    
    private float speed;
    private int lastMoveFrame = 0;
    private int horizontalDirection;
    private int verticalDirection;
    private AbstractSprite sprite;

    protected AbstractEntity() {
        speed = 1f;
    }

    protected AbstractEntity(float speed, int horizontalDirection, 
            int verticalDirection, AbstractSprite sprite) {
        this.speed = speed;
        this.sprite = sprite;
        this.horizontalDirection = horizontalDirection;
        this.verticalDirection = verticalDirection;
    }
    
    public abstract void move();
    public abstract void spawn();
    public abstract void collision();

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

    public int getLastMoveFrame() {
        return lastMoveFrame;
    }

    public void setLastMoveFrame(int lastMoveFrame) {
        this.lastMoveFrame = lastMoveFrame;
    }

    public int getHorizontalDirection() {
        return horizontalDirection;
    }

    public int getVerticalDirection() {
        return verticalDirection;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Float.floatToIntBits(this.sprite.getX());
        hash = 43 * hash + Float.floatToIntBits(this.sprite.getY());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        if (Float.floatToIntBits(this.sprite.getX()) != Float.floatToIntBits(other.sprite.getX())) {
            return false;
        }
        if (Float.floatToIntBits(this.sprite.getY()) != Float.floatToIntBits(other.sprite.getY())) {
            return false;
        }
        return true;
    }
    
}
