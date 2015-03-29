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
import java.util.concurrent.CopyOnWriteArrayList;
import javax.imageio.ImageIO;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.AbstractSpaceCraft;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.factory.EntityFactory;
import pl.kazanik.spaceinvaders.settings.GameSettings;
import pl.kazanik.spaceinvaders.settings.Graphics;

/**
 *
 * @author kazanik
 */
public class EnemyGenerator implements IGenerator {

    private static final EnemyGenerator eg = new EnemyGenerator();
    private EntityFactory factory = new EntityFactory();
    private GameSettings settings = GameSettings.getInstance();
    private int horizontalGap, singleHGap;
    
    private EnemyGenerator() {
        singleHGap = GameConditions.ENEMY_SPRITE_WIDTH+GameConditions.SCENE_WIDTH/10;
        horizontalGap = singleHGap;
    }
    
    public static EnemyGenerator getInstance() {
        return eg;
    }
    
    @Override
    public List<AbstractSpaceCraft> generate() {
//        List<AbstractEntity> enemies = new ArrayList<>();
        List<AbstractSpaceCraft> enemies = new CopyOnWriteArrayList<>();
        List<List<AbstractSpaceCraft>> enemiesWaves = new ArrayList<>();
        BufferedImage spriteImg = Graphics.createImage(GameConditions.ENEMY_SPRITE_PATH);
        for(int i = 1; i <= settings.getDifficulty().getEnemyWaves(); i++) {
            long intervalMilis = settings.getDifficulty().getEnemyWaveIntervalMilis();
            List<AbstractSpaceCraft> wave = new ArrayList<>();
            for(int j = 1; j <= settings.getDifficulty().getEnemiesInWave(); j++) {
                AbstractSpaceCraft enemy = factory.createPhoenixEntity(100.0f, 
                    settings.getDifficulty().getEnemySpeed(), 0f, intervalMilis, 
                    GameConditions.ENEMY_SPRITE_WIDTH, GameConditions.ENEMY_SPRITE_HEIGHT, 
                    GameConditions.WAVE_GAP*i, 0-GameConditions.ENEMY_SPRITE_HEIGHT, 0, spriteImg);
                wave.add(enemy);
                enemies.add(enemy);
                intervalMilis += settings.getDifficulty().getEnemyWaveIntervalMilis();
            }
            enemiesWaves.add(wave);
        }
        EntityManager.getInstance().setEnemiesWaves(enemiesWaves);
        return enemies;
    }
    
    public AbstractSpaceCraft generateEnemy() {
        horizontalGap = (horizontalGap > GameConditions.SCENE_WIDTH-GameConditions.ENEMY_SPRITE_WIDTH) 
                ? singleHGap : horizontalGap+singleHGap;
        BufferedImage spriteImg = Graphics.createImage(GameConditions.ENEMY_SPRITE_PATH);
        AbstractSpaceCraft enemy = factory.createPhoenixEntity(100.0f,
                settings.getDifficulty().getEnemySpeed(), 0f, 0, 
                GameConditions.ENEMY_SPRITE_WIDTH, GameConditions.ENEMY_SPRITE_HEIGHT, 
                horizontalGap, 0, 0, spriteImg);
        return enemy;
    }
}
