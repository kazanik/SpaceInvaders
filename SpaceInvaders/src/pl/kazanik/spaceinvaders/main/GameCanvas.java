/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.settings.GameConditions;

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
//        setOpaque(true);
//        setBackground(Color.black);
//        setForeground(Color.black);
    }

    /*@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
//        setOpaque(true);
//        setBackground(Color.black);
//        setForeground(Color.black);
        System.out.println("paint component");
    }*/

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(GameConditions.SCENE_WIDTH, 
                GameConditions.SCENE_HEIGHT); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
//        setOpaque(true);
//        setBackground(Color.black);
//        setForeground(Color.black);
//        System.out.println("paint");
        scene.draw(g, this);
        /*
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/home/kazanik/Obrazy/sprite/space_ship2_sprite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(img, 0, 0, this);
        */
    }
    
    
}
