/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import pl.kazanik.spaceinvaders.settings.GameConditions;

/**
 *
 * @author kazanik
 */
public class GameMenu implements IDrawable, KeyListener, MouseListener {

    private final String[] options = new String[]{"New game", "Settings", 
        "High scores", "Credits", "Quit game"};
    private final int H_MARGIN_PX = 200;
    private final int V_MARGIN_PX = 20;
    private final int OPTION_V_GAP_PX = 30;
    private final int OPTION_HEIGHT_PX = (GameConditions.WINDOW_HEIGHT
            -((options.length-1)*OPTION_V_GAP_PX)-(V_MARGIN_PX*2))/options.length;
    private final int OPTION_WIDTH_PX = GameConditions.WINDOW_WIDTH
            -(H_MARGIN_PX*2);
    private final int FONT_SIZE_PX = 24;
    private final Color FONT_COLOR = Color.white, CURRENT_FONT_COLOR = Color.YELLOW, 
            BG_COLOR = Color.blue;
    private int currentOptionId;
    private Image bgImage;
    
    public GameMenu() {
    }
    
    @Override
    public void draw(Graphics g, GameCanvas canvas) {
        // not implemented
//        g.drawImage(bgImage, H_MARGIN_PX, V_MARGIN_PX, null);
        g.setFont(new Font("Arial", Font.BOLD, FONT_SIZE_PX));
        int y = V_MARGIN_PX;
        for(String option : options) {
            g.setColor(BG_COLOR);
            g.fillRect(H_MARGIN_PX, y, OPTION_WIDTH_PX, OPTION_HEIGHT_PX);
            g.setColor(FONT_COLOR);
            g.drawString(option, H_MARGIN_PX+100, y+OPTION_V_GAP_PX);
            y += OPTION_V_GAP_PX+OPTION_HEIGHT_PX;
        }
    }

    public void setBgImage(Image bgImage) {
        this.bgImage = bgImage;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // not implemented
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // check up/down arrows for navigating in menu
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // check if any menu option clicked
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // not used
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // not used
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // not used
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // not used
    }
}
