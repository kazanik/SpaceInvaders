/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.factory;

import pl.kazanik.spaceinvaders.weapon.AbstractWeapon;
import pl.kazanik.spaceinvaders.weapon.Cannon;
import pl.kazanik.spaceinvaders.weapon.Weapon;
import pl.kazanik.spaceinvaders.weapon.Weapons;

/**
 *
 * @author kazanik
 */
public class WeaponFactory {
    
    public WeaponFactory() {
        
    }

    public AbstractWeapon createCannon(Weapons weapons) {
        //To change body of generated methods, choose Tools | Templates.
//        AbstractSprite sprite = new MissleSprite(missle.getWidth(), missle.getHeight(), 
//                x, y, missle.getCollisionOffset(), getImage(missle));
        AbstractWeapon weapon = new Cannon(weapons.getFireDelay(), weapons.getAmmoCapacity(), 
                weapons.getAvailableAmmo(), 0, 0, 0);
        return weapon;
    }
}
