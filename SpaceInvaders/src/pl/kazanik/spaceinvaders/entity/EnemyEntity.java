/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import pl.kazanik.spaceinvaders.imodel.AbstractEntity;
import pl.kazanik.spaceinvaders.imodel.AbstractSprite;

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
        System.out.println("Enemy move");
    }

    @Override
    public void born() {
        System.out.println("Enemy born");
    }

    @Override
    public void die() {
        System.out.println("Enemy died");
    }
    
}
