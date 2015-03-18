/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.scene;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pl.kazanik.spaceinvaders.main.GameCanvas;

/**
 *
 * @author kazanik
 */
public class BGLayer implements ISceneLayer {
    
    private BufferedImage bgImage;

    public BGLayer() {
    }

    public BGLayer(BufferedImage bgImage) {
        this.bgImage = bgImage;
    }

    public BufferedImage getBgImage() {
        return bgImage;
    }

    public void setBgImage(BufferedImage bgImage) {
        this.bgImage = bgImage;
    }

    @Override
    public void draw(Graphics g, GameCanvas canvas) {
        System.out.println("bg layer");
        g.drawImage(bgImage, 0, 0, canvas);
    }
    
}
