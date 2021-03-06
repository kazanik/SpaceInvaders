/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import javax.swing.event.MouseInputListener;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;
import pl.kazanik.spaceinvaders.weapon.AbstractWeapon;

/**
 *
 * @author kazanik
 */

public class PlayerEntity extends AbstractSpaceCraft implements 
        MouseInputListener, KeyListener {

    private int direction;
    private int shootDirection = -1;
    private boolean leftPressed, rightPressed, firePressed;
    
    public PlayerEntity() {
        super();
    }

    public PlayerEntity(float health, float speed, float armor, 
            int horizontalDirection, int verticalDirection, 
            AbstractWeapon weapon, AbstractSprite sprite) {
        super(health, speed, armor, 0, 1, weapon, sprite);
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
    public <T extends AbstractEntity> void collision(T other) {
        
    }

    @Override
    public void move() {
//        System.out.println("Player moved");
        float dx = getSprite().getX()+(getSpeed()*direction);
        getSprite().setX(dx);
        if(dx > GameConditions.SCENE_WIDTH+GameConditions.SCENE_HORIZONTAL_GAP
                -getSprite().getWidth())
            getSprite().setX(0+GameConditions.SCENE_HORIZONTAL_GAP);
        if(dx < 0+GameConditions.SCENE_HORIZONTAL_GAP)
            getSprite().setX(GameConditions.SCENE_WIDTH
                    +GameConditions.SCENE_HORIZONTAL_GAP-getSprite().getWidth());
    }
    
//    @Override
//    public void move(int xOffset) {
////        System.out.println("Player moved");
//        float dx = getSprite().getX()+(getSpeed()*direction);
//        getSprite().setX(dx);
//        if(dx > GameConditions.SCENE_WIDTH-getSprite().getWidth())
//            getSprite().setX(0);
//        if(dx < 0)
//            getSprite().setX(GameConditions.SCENE_WIDTH-getSprite().getWidth());
//    }

    @Override
    public void spawn() {
        System.out.println("Player born");
    }

    @Override
    public void destroy() {
        System.out.println("Player died");
    }
    
    @Override
    public void attack() {
//        System.out.println("Player attack");
        int x = (int) (getSprite().getX()+(getSprite().getWidth()/2));
        AbstractEntity missle = getWeapon().fire(
                this, shootDirection, x, (int) getSprite().getY());
        setShots(getShots()+1);
        if(missle != null)
            spacecraftMissles.add(missle);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // not implemented
    }

    @Override
    public void mousePressed(MouseEvent e) {
        firePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        firePressed = false;
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
        int mx = e.getX();
        rightPressed = false;
        leftPressed = false;
        if(mx >= getSprite().getX()+getSprite().getWidth()+20) {
            rightPressed = true;
        } else if(mx <= getSprite().getX()-20) {
            leftPressed = true;
        }
        firePressed = true;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mx = e.getX();
        rightPressed = false;
        leftPressed = false;
        if(mx >= getSprite().getX()+getSprite().getWidth()+20) {
            rightPressed = true;
        } else if(mx <= getSprite().getX()-20) {
            leftPressed = true;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("*******KEY TYPED***********");
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("*******KEY PRESSED***********");
        int code = e.getKeyCode();
//        System.out.println(code);
        switch(code) {
            case GameConditions.FIRE_KEY_CODE:
                firePressed = true;
                break;
            case GameConditions.FIRE_KEY_CODE2:
                firePressed = true;
                break;
            case GameConditions.LEFT_KEY_CODE:
                leftPressed = true;
                break;
            case GameConditions.LEFT_KEY_CODE2:
                leftPressed = true;
                break;
            case GameConditions.RIGHT_KEY_CODE:
                rightPressed = true;
                break;
            case GameConditions.RIGHT_KEY_CODE2:
                rightPressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("*******KEY RELEASED***********");
        int code = e.getKeyCode();
        switch(code) {
            case GameConditions.FIRE_KEY_CODE:
                firePressed = false;
                break;
            case GameConditions.FIRE_KEY_CODE2:
                firePressed = false;
                break;
            case GameConditions.LEFT_KEY_CODE:
                leftPressed = false;
                break;
            case GameConditions.LEFT_KEY_CODE2:
                leftPressed = false;
                break;
            case GameConditions.RIGHT_KEY_CODE:
                rightPressed = false;
                break;
            case GameConditions.RIGHT_KEY_CODE2:
                rightPressed = false;
                break;
        }
    }
    
    public void doAction() {
//        System.out.println("here");
        if(leftPressed) {
            direction = -1;
            move();
        }
        if(rightPressed) {
            direction = 1;
            move();
        }
        if(firePressed) {
            attack();
        }
    }

}
