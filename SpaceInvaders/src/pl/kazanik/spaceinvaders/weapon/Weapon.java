/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.weapon;

import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.missle.Missles;

/**
 *
 * @author kazanik
 */
public class Weapon extends AbstractWeapon {

    private long lastShotTime = 0l;
    
    public Weapon() {
    }

    public Weapon(long fireDelay, int ammoCapacity, int availableAmmo, 
            int clipCapacity, int clipAmmo, int damage) {
        super(fireDelay, ammoCapacity, availableAmmo, clipCapacity, clipAmmo, damage);
    }

    @Override
    public void fire(AbstractEntity entity, int direction, int x, int y) {
        int availableAmmo = getAvailableAmmo();
        long now = System.currentTimeMillis();
        if(availableAmmo > 0 && now-lastShotTime > getFireDelay()) {
            getMissleFactory().create(entity, Missles.CANNON_ROUND, direction, x, y);
            setAvailableAmmo(availableAmmo-1);
        }
    }

    @Override
    public void reload() {
        
    }
    
}
