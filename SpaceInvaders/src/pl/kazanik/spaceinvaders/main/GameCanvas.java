/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.scene.Scene;

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
        System.out.println("paint component");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
//        setOpaque(true);
//        setBackground(Color.black);
//        setForeground(Color.black);
//        scene.draw(g);
        System.out.println("paint");
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/home/kazanik/Obrazy/sprite/space_ship2_sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(img, 0, 0, this);
    }
    
    
}
