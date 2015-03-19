/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.EnumSet;
import javax.swing.event.MouseInputListener;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;

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

    enum Key {
        LEFT(37), UP(38), DOWN(40), RIGHT(39);
        private int code;

        private Key(int code) {
            this.code = code;
        }
        
        public static Key fromCode(int c) {
            for (Key k : values()) {
                if (k.code == c) return k;
            }
            return null;
        }
        
    };
    EnumSet<Key> keySet = EnumSet.noneOf(Key.class);
    
    @Override
    public void move() {
        System.out.println("Player moved");
    }

    @Override
    public void spawn() {
        System.out.println("Player born");
    }

    @Override
    public void die() {
        System.out.println("Player died");
    }
    
    @Override
    public void attack() {
        System.out.println("Player attack");
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
//        System.out.println("*******KEY TYPED***********");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("*******KEY PRESSED***********");
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("*******KEY RELEASED***********");
    }

}
