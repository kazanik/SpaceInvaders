/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;

/**
 *
 * @author kazanik
 */
public class EnemyEntity extends AbstractEntity {

    public EnemyEntity() {
        super();
    }

    public EnemyEntity(AbstractSprite sprite) {
        super(sprite);
    }

    public EnemyEntity(float health, float speed, float armor, 
            AbstractSprite sprite) {
        super(health, speed, armor, sprite);
    }

    @Override
    public void move() {
//        System.out.println("Enemy move");
//        float dy = sprite.getY()+(speed*5);
        float dy = sprite.getY()+1;
        sprite.setY(dy);
        if(dy == GameConditions.SCENE_HEIGHT-sprite.getHeight())
            sprite.setY(0);
    }

    @Override
    public void spawn() {
        System.out.println("Enemy born");
    }

    @Override
    public void die() {
        System.out.println("Enemy died");
    }

    @Override
    public void attack() {
        System.out.println("Enemy attack");
    }
    
}
