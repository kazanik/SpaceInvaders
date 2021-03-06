/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.factory;

import java.awt.image.BufferedImage;
import pl.kazanik.spaceinvaders.entity.AbstractSpaceCraft;
import pl.kazanik.spaceinvaders.entity.PhoenixEntity;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.scene.SpritesLayer;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.settings.GameSettings;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;
import pl.kazanik.spaceinvaders.sprite.NormalSprite;
import pl.kazanik.spaceinvaders.weapon.AbstractWeapon;
import pl.kazanik.spaceinvaders.weapon.Weapons;

/**
 *
 * @author kazanik
 */
public class EntityFactory {
    
    private GameSettings settings = GameSettings.getInstance();
    private WeaponFactory wf = new WeaponFactory();
    
    public AbstractSpaceCraft createPlayer(float health, float speed, float armor, 
            float width, float height, float x, float y, 
            int collisionOffset, BufferedImage spriteImg) {
        AbstractWeapon weapon = wf.createCannon(Weapons.CANNON);
        AbstractSprite sprite = new NormalSprite(width, height, x, y, collisionOffset, spriteImg);
        AbstractSpaceCraft player = new PlayerEntity(health, speed, armor, 0, 1, weapon, sprite);
        SpritesLayer sl = (SpritesLayer) settings.getGameScene().
                getLayer(GameConditions.OBJECTS_LAYER_ID);
        sl.addEntity(player);
        return player;
    }
    
    public AbstractSpaceCraft createPhoenixEntity(float health, float speed, float armor, 
            long intervalMilis, float width, float height, float x, float y, 
            int collisionOffset, BufferedImage spriteImg) {
        AbstractSprite sprite = new NormalSprite(width, height, x, y, collisionOffset, spriteImg);
        AbstractSpaceCraft enemy = new PhoenixEntity(health, speed, armor, intervalMilis, 0, 1, sprite);
        SpritesLayer sl = (SpritesLayer) settings.getGameScene().
                getLayer(GameConditions.OBJECTS_LAYER_ID);
        sl.addEntity(enemy);
        return enemy;
    }
}
