/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import pl.kazanik.spaceinvaders.imodel.AbstractSprite;

/**
 *
 * @author kazanik
 */
public class EnemySprite extends AbstractSprite {

    public EnemySprite() {
    }

    public EnemySprite(int width, int height, int x, int y, int collisionOffset, BufferedImage image) {
        super(width, height, x, y, collisionOffset, image);
    }

    @Override
    public Rectangle collisionRect() {
        System.out.println("Enemy sprite collision rectangle");
        return null;
    }
    
}
