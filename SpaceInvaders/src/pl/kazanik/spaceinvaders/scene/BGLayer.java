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
    private int level;

    public BGLayer() {
    }

    public BGLayer(BufferedImage bgImage) {
        this.bgImage = bgImage;
    }

    public BGLayer(BufferedImage bgImage, int level) {
        this.bgImage = bgImage;
        this.level = level;
    }

    public BufferedImage getBgImage() {
        return bgImage;
    }

    public void setBgImage(BufferedImage bgImage) {
        this.bgImage = bgImage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void draw(Graphics g, GameCanvas canvas) {
        System.out.println("bg layer");
        g.drawImage(bgImage, 0, 0, canvas);
    }

    @Override
    public int level() {
        return level;
    }
    
}
