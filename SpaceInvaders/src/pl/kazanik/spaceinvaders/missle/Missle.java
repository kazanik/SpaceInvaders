/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.missle;

import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;

/**
 *
 * @author kazanik
 */
public class Missle extends AbstractEntity {
    
    private int damage;
    private int direction;

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

    @Override
    public void spawn() {
        // not used
    }

    @Override
    public void collision() {
        
    }

    @Override
    public void move() {
        float dy = getSprite().getY()+(5*getVerticalDirection());
        getSprite().setY(dy);
        if(dy <= 0 || dy >= GameConditions.SCENE_HEIGHT) {
            destroy();
        }
    }
    
    private void destroy() {
        System.out.println("Destroying missle");
        EntityManager.getInstance().removeMissle(this);
    }
}