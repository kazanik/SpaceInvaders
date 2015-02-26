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
public class PlayerEntity extends AbstractEntity {

    @Override
    protected void move() {
        System.out.println("Player moved");
    }

    @Override
    protected void born() {
        System.out.println("Player born");
    }

    @Override
    protected void die() {
        System.out.println("Player died");
    }
    
}
