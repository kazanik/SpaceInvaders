/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.scene;

import java.awt.Graphics;
import pl.kazanik.spaceinvaders.main.GameCanvas;

/**
 *
 * @author kazanik
 */
public class EffectsLayer implements ISceneLayer {

    private int level;

    public EffectsLayer() {
    }

    public EffectsLayer(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    @Override
    public int level() {
        return level;
    }

    @Override
    public void draw(Graphics g, GameCanvas canvas) {
        // draw all effects
        System.out.println("Drawing effects");
    }
    
}
