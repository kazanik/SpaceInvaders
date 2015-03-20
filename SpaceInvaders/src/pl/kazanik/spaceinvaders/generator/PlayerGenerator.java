/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.generator;

import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.factory.EntityFactory;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.settings.GameSettings;

/**
 *
 * @author kazanik
 */
public class PlayerGenerator implements IGenerator {

    private static final PlayerGenerator pg = new PlayerGenerator();
    private EntityFactory factory;
    private GameSettings settings = GameSettings.getInstance();

    private PlayerGenerator() {
        factory = new EntityFactory();
    }
    
    public static PlayerGenerator getInstance() {
        return pg;
    }
    
    @Override
    public AbstractEntity generate() {
//        AbstractEntity player = factory.createPlayer(100f, 1f, 0f, GameConditions.PLAYER_SPRITE_WIDTH, 
//                GameConditions.PLAYER_SPRITE_HEIGHT, 
//                GameConditions.SCENE_WIDTH/2-GameConditions.PLAYER_SPRITE_WIDTH, 
//                GameConditions.SCENE_HEIGHT-GameConditions.PLAYER_SPRITE_HEIGHT, 
//                0, settings.getPlayerImage());
        AbstractEntity player = factory.createPlayer(100f, 
                settings.getDifficulty().getPlayerSpeed(), 0f, 
                GameConditions.PLAYER_SPRITE_WIDTH, 
                GameConditions.PLAYER_SPRITE_HEIGHT, 
                GameConditions.SCENE_WIDTH/2-GameConditions.PLAYER_SPRITE_WIDTH, 
                GameConditions.SCENE_HEIGHT-GameConditions.PLAYER_SPRITE_HEIGHT, 
                0, settings.getPlayerImage());
        return player;
    }
    
}
