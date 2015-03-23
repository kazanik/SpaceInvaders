/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.weapon;

import java.awt.image.BufferedImage;
import pl.kazanik.spaceinvaders.missle.AbstractMissle;

/**
 *
 * @author kazanik
 */
public class Machinegun extends AbstractWeapon {

    public Machinegun() {
    }

    public Machinegun(long fireDelay, int ammoCapacity, int availableAmmo, 
            int clipCapacity, int clipAmmo, int damage, AbstractMissle missle) {
        super(fireDelay, ammoCapacity, availableAmmo, clipCapacity, clipAmmo, 
                damage, missle);
    }

    @Override
    public void fire() {
        
    }

    @Override
    public void reload() {
        
    }
    
}
