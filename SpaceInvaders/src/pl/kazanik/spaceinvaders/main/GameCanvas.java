/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.awt.Graphics;
import javax.swing.JComponent;
import pl.kazanik.spaceinvaders.model.PlayerEntity;

/**
 *
 * @author kazanik
 */
public class GameCanvas extends JComponent {

    public GameCanvas(PlayerEntity player) {
        addMouseListener(player);
        addMouseMotionListener(player);
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
