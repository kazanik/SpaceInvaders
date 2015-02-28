/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kazanik
 */
public class Scene {
    
    private static final Scene scene = new Scene();
    private List<SceneLayer> layers;

    private Scene() {
        layers = new ArrayList<>();
    }

    public static Scene getInstance() {
        return scene;
    }
    
    public List<SceneLayer> getLayers() {
        return layers;
    }

    public void setLayers(List<SceneLayer> layers) {
        this.layers = layers;
    }
    
    public void addLayer(SceneLayer l) {
        layers.add(l);
    }
    
    public void draw(Graphics g) {
        for(SceneLayer layer : layers) {
            layer.draw(g);
        }
    }
}
