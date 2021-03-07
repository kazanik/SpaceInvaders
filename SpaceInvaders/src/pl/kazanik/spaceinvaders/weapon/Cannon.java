/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.weapon;

import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.factory.MissleFactory;
import pl.kazanik.spaceinvaders.missle.Missles;

/**
 *
 * @author kazanik
 */
public class Cannon extends AbstractWeapon {

    private long lastShotTime = 0l;
    
    public Cannon() {
    }

    public Cannon(long fireDelay, int ammoCapacity, int availableAmmo, 
            int clipCapacity, int clipAmmo, int damage) {
        super(fireDelay, ammoCapacity, availableAmmo, clipCapacity, clipAmmo, 
                damage);
    }

    @Override
    public AbstractEntity fire(AbstractEntity entity, int direction, int x, int y) {
        MissleFactory mf = new MissleFactory();
        int availableAmmo = getAvailableAmmo();
        long now = System.currentTimeMillis();
        AbstractEntity missle = null;
        if(availableAmmo > 0 && now-lastShotTime > getFireDelay()) {
            missle = mf.create(entity, Missles.CANNON_ROUND, direction, x, y);
            setAvailableAmmo(availableAmmo-1);
            lastShotTime = System.currentTimeMillis();
        }
        return missle;
    }

    @Override
    public void reload() {
        
    }
    
}
