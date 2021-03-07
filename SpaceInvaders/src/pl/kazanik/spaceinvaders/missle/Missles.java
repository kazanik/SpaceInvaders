/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.missle;

import java.awt.Color;
import pl.kazanik.spaceinvaders.settings.GameConditions;

/**
 *
 * @author kazanik
 */
public enum Missles {
    
    CANNON_ROUND(10, 3, 0, 2, 4, Color.WHITE, GameConditions.CANNON_MISSLE_SOUND_PATH);
    
    private final int damage;
    private final int speed;
    private final int collisionOffset;
    private final int width;
    private final int height;
    private final Color color;
    private final String soundPath;

    private Missles(int damage, int speed, int collisionOffset, int width, 
            int height, Color color, String soundPath) {
        this.damage = damage;
        this.speed = speed;
        this.collisionOffset = collisionOffset;
        this.width = width;
        this.height = height;
        this.color = color;
        this.soundPath = soundPath;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCollisionOffset() {
        return collisionOffset;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public String getSoundPath() {
        return soundPath;
    }

}
