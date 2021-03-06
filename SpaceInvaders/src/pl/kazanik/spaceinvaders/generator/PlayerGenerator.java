/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.generator;

import pl.kazanik.spaceinvaders.entity.AbstractSpaceCraft;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.factory.EntityFactory;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.settings.GameSettings;
import pl.kazanik.spaceinvaders.settings.Graphics;

/**
 *
 * @author kazanik
 */
public class PlayerGenerator {

    private EntityManager em = EntityManager.getInstance();
    
    public PlayerGenerator() {
        
    }

    public AbstractSpaceCraft generate() {
//        AbstractEntity player = factory.createPlayer(100f, 1f, 0f, GameConditions.PLAYER_SPRITE_WIDTH, 
//                GameConditions.PLAYER_SPRITE_HEIGHT, 
//                GameConditions.SCENE_WIDTH/2-GameConditions.PLAYER_SPRITE_WIDTH, 
//                GameConditions.SCENE_HEIGHT-GameConditions.PLAYER_SPRITE_HEIGHT, 
//                0, settings.getPlayerImage());
        Graphics g = new Graphics();
        EntityFactory factory = new EntityFactory();
        AbstractSpaceCraft player = factory.createPlayer(100f, 
                GameSettings.getInstance().getDifficulty().getPlayerSpeed(), 0f, 
                GameConditions.PLAYER_SPRITE_WIDTH, 
                GameConditions.PLAYER_SPRITE_HEIGHT, 
                GameConditions.SCENE_WIDTH/2-GameConditions.PLAYER_SPRITE_WIDTH, 
                GameConditions.SCENE_HEIGHT-GameConditions.PLAYER_SPRITE_HEIGHT, 
                0, g.createImage(GameConditions.PLAYER_SPRITE_PATH));
        em.addPlayer(player);
        em.setPlayer(player);
        return player;
    }
    
}
