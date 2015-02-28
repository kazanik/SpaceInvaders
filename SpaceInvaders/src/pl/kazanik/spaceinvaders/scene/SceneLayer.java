/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.scene;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import pl.kazanik.spaceinvaders.imodel.AbstractSprite;

/**
 *
 * @author kazanik
 */
public class SceneLayer {
    
    private int level;
    private List<AbstractSprite> sprites;

    public SceneLayer() {
        sprites = new ArrayList<>();
    }

    public SceneLayer(int level) {
        this.level = level;
        sprites = new ArrayList<>();
    }

    public SceneLayer(List<AbstractSprite> sprites) {
        this.sprites = sprites;
    }

    public SceneLayer(int level, List<AbstractSprite> sprites) {
        this.level = level;
        this.sprites = sprites;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
