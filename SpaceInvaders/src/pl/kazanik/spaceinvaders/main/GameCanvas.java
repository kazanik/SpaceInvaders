/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;
import pl.kazanik.spaceinvaders.imodel.AbstractEntity;
import pl.kazanik.spaceinvaders.model.PlayerEntity;
import pl.kazanik.spaceinvaders.model.Scene;

/**
 *
 * @author kazanik
 */
public class GameCanvas extends /*JComponent*/ JPanel {

    private Scene scene;
    
    public GameCanvas(Scene scene, AbstractEntity player) {
        this.scene = scene;
        PlayerEntity player2 = (PlayerEntity) player;
        addMouseListener(player2);
        addMouseMotionListener(player2);
        addKeyListener(player2);
        requestFocusInWindow();
        setOpaque(true);
        setBackground(Color.black);
//        setForeground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
//        setOpaque(true);
        setBackground(Color.black);
//        setForeground(Color.black);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
//        setOpaque(true);
        setBackground(Color.black);
//        setForeground(Color.black);
        scene.draw(g);
    }
    
    
}
