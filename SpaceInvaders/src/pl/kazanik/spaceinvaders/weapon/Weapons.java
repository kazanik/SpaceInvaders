/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.weapon;

/**
 *
 * @author kazanik
 */
public enum Weapons {
    
    CANNON(50, 500, 500);
    
    private final long fireDelay;
    private final int ammoCapacity;
    private final int availableAmmo;

    private Weapons(long fireDelay, int ammoCapacity, int availableAmmo) {
        this.fireDelay = fireDelay;
        this.ammoCapacity = ammoCapacity;
        this.availableAmmo = availableAmmo;
    }

    public long getFireDelay() {
        return fireDelay;
    }

    public int getAmmoCapacity() {
        return ammoCapacity;
    }

    public int getAvailableAmmo() {
        return availableAmmo;
    }
    
}
