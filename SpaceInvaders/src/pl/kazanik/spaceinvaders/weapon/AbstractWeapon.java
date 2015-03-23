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
public abstract class AbstractWeapon {
    
    private long fireDelay;
    private int ammoCapacity;
    private int availableAmmo;
    private int clipCapacity;
    private int clipAmmo;
    private int damage;
    private AbstractMissle missle;

    // private AbstractMissle bullet;
    protected AbstractWeapon() {
    }

    protected AbstractWeapon(long fireDelay, int ammoCapacity, int availableAmmo, 
            int clipCapacity, int clipAmmo, int damage, AbstractMissle missle) {
        this.fireDelay = fireDelay;
        this.ammoCapacity = ammoCapacity;
        this.availableAmmo = availableAmmo;
        this.clipCapacity = clipCapacity;
        this.clipAmmo = clipAmmo;
        this.damage = damage;
        this.missle = missle;
    }
    
    public abstract void fire();
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

    public AbstractMissle getMissle() {
        return missle;
    }

    public void setMissle(AbstractMissle missle) {
        this.missle = missle;
    }
    
}
