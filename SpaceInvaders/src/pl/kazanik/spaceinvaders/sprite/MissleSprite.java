/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.sprite;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author kazanik
 */
public class MissleSprite extends AbstractSprite {

    public MissleSprite() {
    }

    public MissleSprite(float width, float height, float x, float y, 
            int collisionOffset, BufferedImage image) {
        super(width, height, x, y, collisionOffset, image);
    }

    @Override
    public Rectangle collisionRect() {
        return new Rectangle((int) getX(), (int) getY(), (int) getWidth(), 
                (int) getHeight());
    }
    
}
