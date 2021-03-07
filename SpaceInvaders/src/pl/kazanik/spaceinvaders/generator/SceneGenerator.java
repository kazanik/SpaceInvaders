/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.generator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.scene.BGLayer;
import pl.kazanik.spaceinvaders.scene.EffectsLayer;
import pl.kazanik.spaceinvaders.scene.ISceneLayer;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.scene.SpritesLayer;

/**
 *
 * @author kazanik
 */
public class SceneGenerator {
    
    public SceneGenerator() {
    }
    
    public Scene generate() {
        Scene scene = Scene.getInstance();
        LinkedList<ISceneLayer> sceneLayers = new LinkedList<>();
        BufferedImage bgImage = new BufferedImage(GameConditions.SCENE_WIDTH, 
                GameConditions.SCENE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = bgImage.createGraphics();
        graphics.setPaint(new Color(0, 0, 0));
        graphics.fillRect(0, 0, bgImage.getWidth(), bgImage.getHeight());
        BGLayer bgLayer = new BGLayer(bgImage, GameConditions.BG_LAYER_ID);
        SpritesLayer spLayer = new SpritesLayer(GameConditions.OBJECTS_LAYER_ID);
        EffectsLayer effLayer = new EffectsLayer(GameConditions.EFFECTS_LAYER_ID);
        sceneLayers.add(bgLayer);
        sceneLayers.add(spLayer);
        sceneLayers.add(effLayer); // game objects layer|effects layer
        scene.setLayers(sceneLayers);
        return scene;
    }
}
