/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import pl.kazanik.spaceinvaders.imodel.AbstractSprite;

/**
 *
 * @author kazanik
 */
public class SceneLayer {
    
    private List<AbstractSprite> sprites;

    public SceneLayer() {
        sprites = new ArrayList<>();
    }

    public SceneLayer(List<AbstractSprite> sprites) {
        this.sprites = sprites;
    }
    
    public List<AbstractSprite> getSprites() {
        return sprites;
    }

    public void setSprites(List<AbstractSprite> sprites) {
        this.sprites = sprites;
    }
    
    public void addSprite(AbstractSprite sprite) {
        sprites.add(sprite);
    }
    
    public void draw(Graphics g) {
        for(AbstractSprite sprite : sprites) {
            sprite.draw(g);
        }
    }
}
