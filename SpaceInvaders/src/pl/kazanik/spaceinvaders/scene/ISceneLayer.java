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
public interface ISceneLayer {
    
    public abstract void draw(Graphics g, GameCanvas canvas);
}
