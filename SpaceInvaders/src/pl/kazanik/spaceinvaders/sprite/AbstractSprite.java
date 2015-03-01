/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.sprite;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author kazanik
 */
public abstract class AbstractSprite {
    
    private float width;
    private float height;
    private float x;
    private float y;
    private int collisionOffset;
    private BufferedImage image;

    protected AbstractSprite() {
    }

    protected AbstractSprite(float width, float height, float x, float y, 
            int collisionOffset, BufferedImage image) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.collisionOffset = collisionOffset;
        this.image = image;
    }

    public abstract Rectangle collisionRect();
    
    public void draw(Graphics g) {
        g.drawImage(image, (int)x, (int)y, (int)(x+width), (int)(y+height), 
                0, 0, image.getWidth(), image.getHeight(), null);
    }
    
    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
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
