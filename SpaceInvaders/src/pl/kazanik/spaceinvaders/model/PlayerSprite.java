/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.model;

import java.awt.Rectangle;
import pl.kazanik.spaceinvaders.imodel.AbstractSprite;

/**
 *
 * @author kazanik
 */
public class PlayerSprite extends AbstractSprite {

    @Override
    protected Rectangle collisionRect() {
        System.out.println("Player sprite collision rectangle");
        return null;
    }
    
}
