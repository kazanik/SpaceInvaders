/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.scene;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pl.kazanik.spaceinvaders.main.GameCanvas;

/**
 *
 * @author kazanik
 */
public class Scene {
    
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
    
    public void draw(Graphics g, GameCanvas canvas) {
        for(ISceneLayer layer : layers) {
            layer.draw(g, canvas);
        }
    }
}
