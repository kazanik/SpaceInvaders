/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.generator;

import java.util.ArrayList;
import java.util.List;
import pl.kazanik.spaceinvaders.consts.GameConditions;
import pl.kazanik.spaceinvaders.imodel.IGenerator;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.scene.SceneLayer;

/**
 *
 * @author kazanik
 */
public class SceneGenerator implements IGenerator {
    
    private static final SceneGenerator sg = new SceneGenerator();
    
    private SceneGenerator() {
    }
    
    public static SceneGenerator getInstance() {
        return sg;
    }
    
    @Override
    public Scene generate() {
        Scene scene = Scene.getInstance();
        List<SceneLayer> sceneLayers = new ArrayList<>();
        for(int num = 0; num < GameConditions.SCENE_LAYERS; num++) {
            sceneLayers.add(new SceneLayer(num)); // game objects layer|effects layer
        }
        scene.setLayers(sceneLayers);
        return scene;
    }
}
