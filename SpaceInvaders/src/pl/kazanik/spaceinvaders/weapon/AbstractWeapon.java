/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.weapon;

import java.io.Serializable;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.factory.MissleFactory;

/**
 *
 * @author kazanik
 */
public abstract class AbstractWeapon implements Serializable {
    
    private long fireDelay;
    private int ammoCapacity;
    private int availableAmmo;
    private int clipCapacity;
    private int clipAmmo;
    private int damage;
//    private MissleFactory missleFactory;

    // private AbstractMissle bullet;
    protected AbstractWeapon() {
    }

    protected AbstractWeapon(long fireDelay, int ammoCapacity, int availableAmmo, 
            int clipCapacity, int clipAmmo, int damage) {
        this.fireDelay = fireDelay;
        this.ammoCapacity = ammoCapacity;
        this.availableAmmo = availableAmmo;
        this.clipCapacity = clipCapacity;
        this.clipAmmo = clipAmmo;
        this.damage = damage;
//        this.missleFactory = new MissleFactory();
    }
    
    public abstract AbstractEntity fire(AbstractEntity entity, int direction, int x, int y);
    public abstract void reload();

    public long getFireDelay() {
        return fireDelay;
    }

    public void setFireDelay(long fireDelay) {
        this.fireDelay = fireDelay;
    }

    public int getAmmoCapacity() {
        return ammoCapacity;
    }

    public void setAmmoCapacity(int ammoCapacity) {
        this.ammoCapacity = ammoCapacity;
    }

    public int getAvailableAmmo() {
        return availableAmmo;
    }

    public void setAvailableAmmo(int availableAmmo) {
        this.availableAmmo = availableAmmo;
    }

    public int getClipCapacity() {
        return clipCapacity;
    }

    public void setClipCapacity(int clipCapacity) {
        this.clipCapacity = clipCapacity;
    }

    public int getClipAmmo() {
        return clipAmmo;
    }

    public void setClipAmmo(int clipAmmo) {
        this.clipAmmo = clipAmmo;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

//    public MissleFactory getMissleFactory() {
//        return missleFactory;
//    }
//
//    public void setMissleFactory(MissleFactory missleFactory) {
//        this.missleFactory = missleFactory;
//    }

}
