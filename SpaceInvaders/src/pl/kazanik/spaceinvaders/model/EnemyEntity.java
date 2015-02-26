/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.model;

import pl.kazanik.spaceinvaders.imodel.AbstractEntity;

/**
 *
 * @author kazanik
 */
public class EnemyEntity extends AbstractEntity {

    @Override
    protected void move() {
        System.out.println("Enemy move");
    }

    @Override
    protected void born() {
        System.out.println("Enemy born");
    }

    @Override
    protected void die() {
        System.out.println("Enemy died");
    }
    
}
