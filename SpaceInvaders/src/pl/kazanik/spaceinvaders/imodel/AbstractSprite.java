/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.imodel;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author kazanik
 */
public abstract class AbstractSprite {
    
    private int width;
    private int height;
    private int x;
    private int y;
    private int collisionOffset;
    private BufferedImage image;

    protected abstract Rectangle collisionRect();
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCollisionOffset() {
        return collisionOffset;
    }

    public void setCollisionOffset(int collisionOffset) {
        this.collisionOffset = collisionOffset;
    }
    
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
}
