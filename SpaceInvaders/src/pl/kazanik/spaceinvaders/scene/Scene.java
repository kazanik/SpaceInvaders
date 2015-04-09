/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.scene;

import java.awt.Graphics;
import java.util.LinkedList;
import pl.kazanik.spaceinvaders.main.GameCanvas;
import pl.kazanik.spaceinvaders.main.IDrawable;

/**
 *
 * @author kazanik
 */
public class Scene implements IDrawable {
    
    private static final Scene scene = new Scene();
    private LinkedList<ISceneLayer> layers;

    private Scene() {
        layers = new LinkedList<>();
    }

    public static Scene getInstance() {
        return scene;
    }
    
    public LinkedList<ISceneLayer> getLayers() {
        return layers;
    }

    public void setLayers(LinkedList<ISceneLayer> layers) {
        this.layers = layers;
    }
    
    public void addLayer(ISceneLayer l) {
        layers.addLast(l);
    }
    
    public ISceneLayer getLayer(int level) {
        return layers.get(level);
    }
    
    @Override
    public void draw(Graphics g, GameCanvas canvas) {
        for(ISceneLayer layer : layers) {
            layer.draw(g, canvas);
        }
    }
}
