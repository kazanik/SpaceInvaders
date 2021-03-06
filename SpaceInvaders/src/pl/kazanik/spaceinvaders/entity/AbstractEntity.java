/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import java.io.Serializable;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;

/**
 *
 * @author kazanik
 */
public abstract class AbstractEntity implements Serializable {
    
    private float speed;
    private int lastMoveFrame = 0;
    private AbstractSprite sprite;

    protected AbstractEntity() {
        speed = 1f;
    }

    protected AbstractEntity(float speed, int horizontalDirection, 
            int verticalDirection, AbstractSprite sprite) {
        this.speed = speed;
        this.sprite = sprite;
    }
    
    public abstract void move();
    public abstract void spawn();
    public abstract <T extends AbstractEntity> void collision(T other);

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

}
