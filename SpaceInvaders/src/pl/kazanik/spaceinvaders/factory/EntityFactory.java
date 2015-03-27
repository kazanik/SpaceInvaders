/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.factory;

import java.awt.image.BufferedImage;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.EnemyEntity;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.scene.SpritesLayer;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.settings.GameSettings;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;
import pl.kazanik.spaceinvaders.sprite.EnemySprite;
import pl.kazanik.spaceinvaders.sprite.PlayerSprite;
import pl.kazanik.spaceinvaders.weapon.AbstractWeapon;
import pl.kazanik.spaceinvaders.weapon.Cannon;
import pl.kazanik.spaceinvaders.weapon.Weapons;

/**
 *
 * @author kazanik
 */
public class EntityFactory {
    
    private GameSettings settings = GameSettings.getInstance();
    private WeaponFactory wf = new WeaponFactory();
    
    public AbstractEntity createPlayer(float health, float speed, float armor, 
            float width, float height, float x, float y, 
            int collisionOffset, BufferedImage spriteImg) {
        AbstractWeapon weapon = wf.createCannon(Weapons.CANNON);
        AbstractSprite sprite = new PlayerSprite(width, height, x, y, collisionOffset, spriteImg);
        AbstractEntity player = new PlayerEntity(health, speed, armor, 0, 1, sprite, weapon);
        SpritesLayer sl = (SpritesLayer) settings.getGameScene().
                getLayer(GameConditions.OBJECTS_LAYER_ID);
        sl.addEntity(player);
        return player;
    }
    
    public AbstractEntity createEnemy(float health, float speed, float armor, 
            long intervalMilis, float width, float height, float x, float y, 
            int collisionOffset, BufferedImage spriteImg) {
        AbstractSprite sprite = new EnemySprite(width, height, x, y, collisionOffset, spriteImg);
        AbstractEntity enemy = new EnemyEntity(health, speed, armor, intervalMilis, 0, 1, sprite);
        SpritesLayer sl = (SpritesLayer) settings.getGameScene().
                getLayer(GameConditions.OBJECTS_LAYER_ID);
        sl.addEntity(enemy);
        return enemy;
    }
}
