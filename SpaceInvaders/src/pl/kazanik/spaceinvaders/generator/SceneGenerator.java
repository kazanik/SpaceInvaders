/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.generator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pl.kazanik.spaceinvaders.consts.GameConditions;
import pl.kazanik.spaceinvaders.scene.BGLayer;
import pl.kazanik.spaceinvaders.scene.ISceneLayer;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.scene.SpritesLayer;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;

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
        LinkedList<ISceneLayer> sceneLayers = new LinkedList<>();
        BufferedImage bgImage = new BufferedImage(GameConditions.SCENE_WIDTH, 
                GameConditions.SCENE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = bgImage.createGraphics();
        graphics.setPaint(new Color(0, 0, 0));
        graphics.fillRect(0, 0, bgImage.getWidth(), bgImage.getHeight());
        BGLayer bgLayer = new BGLayer(bgImage);
        sceneLayers.add(bgLayer);
        for(int lvl = 1; lvl < GameConditions.SCENE_LAYERS; lvl++) {
            sceneLayers.add(new SpritesLayer(lvl)); // game objects layer|effects layer
        }
        scene.setLayers(sceneLayers);
        return scene;
    }
}
