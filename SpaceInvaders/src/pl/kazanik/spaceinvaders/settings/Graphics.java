/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.settings;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author kazanik
 */
public class Graphics {
    
    public BufferedImage createImage(String path) {
        BufferedImage spriteImg = null;
        try {
//            spriteImg = ImageIO.read(new File(path));
            spriteImg = ImageIO.read(getClass().getResource(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return spriteImg;
    }
}
