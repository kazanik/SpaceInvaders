/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.generator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.EnemyEntity;
import pl.kazanik.spaceinvaders.factory.EntityFactory;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.scene.SpritesLayer;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;
import pl.kazanik.spaceinvaders.sprite.EnemySprite;

/**
 *
 * @author kazanik
 */
public class EnemyGenerator implements IGenerator {

    private static final EnemyGenerator eg = new EnemyGenerator();
    private EntityFactory factory = new EntityFactory();
    
    private EnemyGenerator() {
        
    }
    
    public static EnemyGenerator getInstance() {
        return eg;
    }
    
    @Override
    public List<AbstractEntity> generate() {
        List<AbstractEntity> enemies = new ArrayList<>();
        int waveNum = 1;
        BufferedImage spriteImg = null;
        try {
            spriteImg = ImageIO.read(new File(GameConditions.ENEMY_SPRITE_PATH));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        AbstractEntity enemy = factory.createEnemy(100.0f, 0.1f, 0f, 
//                GameConditions.ENEMY_SPRITE_WIDTH, GameConditions.ENEMY_SPRITE_HEIGHT, 
//                GameConditions.WAVE_GAP*waveNum, 0, 0, spriteImg);
        AbstractEntity enemy = factory.createEnemy(100.0f, 50000f, 0f, 
                GameConditions.ENEMY_SPRITE_WIDTH, GameConditions.ENEMY_SPRITE_HEIGHT, 
                GameConditions.WAVE_GAP*waveNum, 0, 0, spriteImg);
        enemies.add(enemy);
        return enemies;
    }
}
