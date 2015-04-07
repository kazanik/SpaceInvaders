/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.missle;

import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;

/**
 *
 * @author kazanik
 */
public class Missle extends AbstractEntity {
    
    private int damage;
    private int direction;
    private boolean destroyed = false;

    public Missle() {
    }

    public Missle(int damage, int direction, float speed, 
            int horizontalDirection, int verticalDirection, AbstractSprite sprite) {
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

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    @Override
    public void spawn() {
        // not used
    }

    @Override
    public void collision(AbstractEntity other) {
        this.destroy();
    }

    @Override
    public void move() {
        if(!destroyed) {
            float dy = getSprite().getY()+(5*getDirection());
            getSprite().setY(dy);
            if(dy <= 0 || dy >= GameConditions.SCENE_HEIGHT) {
                destroy();
            }
        }
    }
    
    private void destroy() {
//        System.out.println("Destroying missle");
        destroyed = true;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Float.floatToIntBits(getSprite().getX());
        hash = 43 * hash + Float.floatToIntBits(getSprite().getY());
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
        if (Float.floatToIntBits(this.getSprite().getX()) != Float.floatToIntBits(other.getSprite().getX())) {
            return false;
        }
        if (Float.floatToIntBits(this.getSprite().getY()) != Float.floatToIntBits(other.getSprite().getY())) {
            return false;
        }
        return true;
    }
}
