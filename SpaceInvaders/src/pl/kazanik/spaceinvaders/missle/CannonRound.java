/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.missle;

import pl.kazanik.spaceinvaders.sprite.AbstractSprite;

/**
 *
 * @author kazanik
 */
public class CannonRound extends AbstractMissle {

    public CannonRound() {
    }

    public CannonRound(int damage, int direction, float speed, 
            int horizontalDirection, int verticalDirection, AbstractSprite sprite) {
        super(damage, direction, speed, horizontalDirection, verticalDirection, sprite);
    }
    
    @Override
    public void move() {
        
    }
}
