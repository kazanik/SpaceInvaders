/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.weapon;

import pl.kazanik.spaceinvaders.missle.Missles;

/**
 *
 * @author kazanik
 */
public class Cannon extends AbstractWeapon {

    public Cannon() {
    }

    public Cannon(long fireDelay, int ammoCapacity, int availableAmmo, 
            int clipCapacity, int clipAmmo, int damage) {
        super(fireDelay, ammoCapacity, availableAmmo, clipCapacity, clipAmmo, 
                damage);
    }

    @Override
    public void fire(int direction, int x, int y) {
        getMissleFactory().create(Missles.CANNON_ROUND, direction, x, y);
    }

    @Override
    public void reload() {
        
    }
    
}
