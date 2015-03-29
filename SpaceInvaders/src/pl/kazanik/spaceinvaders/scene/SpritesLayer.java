/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.scene;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.main.GameCanvas;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;

/**
 *
 * @author kazanik
 */
public class SpritesLayer implements ISceneLayer {
    
    private int level;
    private List<AbstractEntity> entities;

    public SpritesLayer() {
//        entities = new ArrayList<>();
        entities = new CopyOnWriteArrayList<>();
    }

    public SpritesLayer(int level) {
        this.level = level;
        entities = new CopyOnWriteArrayList<>();
    }

    public SpritesLayer(List<AbstractEntity> entities) {
        this.entities = entities;
    }

    public SpritesLayer(int level, List<AbstractEntity> entities) {
        this.level = level;
        this.entities = entities;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public List<AbstractEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<AbstractEntity> entities) {
        this.entities = entities;
    }
    
    public void addEntity(AbstractEntity entity) {
        entities.add(entity);
    }
    
    public boolean removeEntity(AbstractEntity entity) {
        return entities.remove(entity);
    }
    
    @Override
    public void draw(Graphics g, GameCanvas canvas) {
//        System.out.println("Draw sprites layer");
        for(AbstractEntity entity : entities) {
            entity.getSprite().draw(g, canvas);
        }
    }

    @Override
    public int level() {
        return level;
    }
}
