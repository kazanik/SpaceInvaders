/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.generator;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.entity.AbstractSpaceCraft;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.factory.EntityFactory;
import pl.kazanik.spaceinvaders.settings.GameSettings;
import pl.kazanik.spaceinvaders.settings.Graphics;

/**
 *
 * @author kazanik
 */
public class EnemyGenerator {

    private static final EnemyGenerator eg = new EnemyGenerator();
    private EntityFactory factory = new EntityFactory();
    private GameSettings settings = GameSettings.getInstance();
    private EntityManager em = EntityManager.getInstance();
    private int horizontalGap, singleHGap;
    
    public EnemyGenerator() {
        singleHGap = GameConditions.ENEMY_SPRITE_WIDTH
                +(GameConditions.SCENE_WIDTH/10);
        horizontalGap = singleHGap;
    }
    
    public List<AbstractSpaceCraft> generate() {
//        List<AbstractEntity> enemies = new ArrayList<>();
        Graphics g = new Graphics();
        List<AbstractSpaceCraft> enemies = new CopyOnWriteArrayList<>();
        List<List<AbstractSpaceCraft>> enemiesWaves = new CopyOnWriteArrayList<>();
        BufferedImage spriteImg = g.createImage(GameConditions.PHOENIX_SPRITE_PATH);
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
        em.setEnemiesWaves(enemiesWaves);
        return enemies;
    }
    
    public AbstractSpaceCraft generateEnemy() {
        Graphics g = new Graphics();
        horizontalGap = (horizontalGap+singleHGap > GameConditions.SCENE_WIDTH
                +GameConditions.SCENE_HORIZONTAL_GAP-GameConditions.ENEMY_SPRITE_WIDTH) 
                ? singleHGap : horizontalGap+singleHGap;
        BufferedImage spriteImg = g.createImage(GameConditions.PHOENIX_SPRITE_PATH);
        AbstractSpaceCraft enemy = factory.createPhoenixEntity(100.0f,
                settings.getDifficulty().getEnemySpeed(), 0f, 0, 
                GameConditions.ENEMY_SPRITE_WIDTH, GameConditions.ENEMY_SPRITE_HEIGHT, 
                horizontalGap, 0, 0, spriteImg);
        return enemy;
    }
}
