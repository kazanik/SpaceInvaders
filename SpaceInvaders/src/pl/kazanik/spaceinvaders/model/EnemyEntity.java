/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.model;

import pl.kazanik.spaceinvaders.imodel.AbstractEntity;
import pl.kazanik.spaceinvaders.imodel.AbstractSprite;

/**
 *
 * @author kazanik
 */
public class EnemyEntity extends AbstractEntity {

    public EnemyEntity() {
    }

    public EnemyEntity(float health, float speed, AbstractSprite sprite) {
        super(health, speed, sprite);
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
