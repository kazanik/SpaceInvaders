/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import pl.kazanik.spaceinvaders.imodel.AbstractEntity;
import pl.kazanik.spaceinvaders.imodel.AbstractSprite;

/**
 *
 * @author kazanik
 */
public class PlayerEntity extends AbstractEntity implements 
        MouseInputListener, KeyListener {

    public PlayerEntity() {
        super();
    }

    public PlayerEntity(AbstractSprite sprite) {
        super(sprite);
    }

    public PlayerEntity(float health, float speed, float armor, 
            AbstractSprite sprite) {
        super(health, speed, armor, sprite);
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

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
