/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.settings.GameConditions;

/**
 *
 * @author kazanik
 */
public class GameCanvas extends JComponent /*JPanel*/ {

    private Scene scene;
    
    public GameCanvas(Scene scene, AbstractEntity player2) {
        this.scene = scene;
        PlayerEntity player = (PlayerEntity) player2;
        setFocusable(true);
        addMouseListener(player);
        addMouseMotionListener(player);
        addKeyListener(player);
        requestFocusInWindow();
//        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
//        setOpaque(true);
        scene.draw(g, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(GameConditions.WINDOW_WIDTH, 
                GameConditions.WINDOW_HEIGHT); //To change body of generated methods, choose Tools | Templates.
    }


    /*@Override
    public void paint(Graphics g) {
//        super.paint(g); //To change body of generated methods, choose Tools | Templates.
//        setOpaque(true);
        scene.draw(g, this);
    }*/
    
    
}
