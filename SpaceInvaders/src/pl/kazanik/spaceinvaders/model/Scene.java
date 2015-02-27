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
    
    private List<SceneLayer> layers;

    public Scene() {
        layers = new ArrayList<>();
    }

    public Scene(List<SceneLayer> layers) {
        this.layers = layers;
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
