/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.settings.GameConditions;

/**
 *
 * @author kazanik
 */
public class GameCanvas extends JComponent /*JPanel*/ {

//    private Scene scene;
//    private GameMenu menu;
    IDrawable container;
    
    public GameCanvas(IDrawable container, AbstractEntity player2) {
//        this.scene = scene;
//        this.menu = menu;
        this.container = container;
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
        container.draw(g, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(GameConditions.WINDOW_WIDTH, 
                GameConditions.WINDOW_HEIGHT); //To change body of generated methods, choose Tools | Templates.
    }

    public IDrawable getContainer() {
        return container;
    }

    public void setContainer(IDrawable container) {
        this.container = container;
    }
}
