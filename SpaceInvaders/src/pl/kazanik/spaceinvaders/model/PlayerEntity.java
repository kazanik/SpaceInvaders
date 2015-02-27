/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.model;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import pl.kazanik.spaceinvaders.imodel.AbstractEntity;
import pl.kazanik.spaceinvaders.imodel.AbstractSprite;

/**
 *
 * @author kazanik
 */
public class PlayerEntity extends AbstractEntity implements MouseInputListener {

    public PlayerEntity() {
    }

    public PlayerEntity(float health, float speed, AbstractSprite sprite) {
        super(health, speed, sprite);
    }

    @Override
    public void move() {
        System.out.println("Player moved");
    }

    @Override
    public void born() {
        System.out.println("Player born");
    }

    @Override
    public void die() {
        System.out.println("Player died");
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // not implemented
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // not implemented
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // not implemented
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}
