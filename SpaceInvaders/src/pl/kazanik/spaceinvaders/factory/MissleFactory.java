/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.factory;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.missle.Missle;
import pl.kazanik.spaceinvaders.missle.Missles;
import pl.kazanik.spaceinvaders.scene.SpritesLayer;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.settings.GameSettings;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;
import pl.kazanik.spaceinvaders.sprite.NormalSprite;

/**
 *
 * @author kazanik
 */
public class MissleFactory {

    private GameSettings settings = GameSettings.getInstance();
    
    public MissleFactory() {
        
    }

    public <T extends AbstractEntity>void create(T entity, Missles missle, 
            int direction, int x, int y) {
        //To change body of generated methods, choose Tools | Templates.
        AbstractSprite sprite = new NormalSprite(missle.getWidth(), missle.getHeight(), 
                x, y, missle.getCollisionOffset(), getImage(missle));
        AbstractEntity missleEntity = new Missle(missle.getDamage(), direction, 
                missle.getSpeed(), 0, -1, sprite);
        SpritesLayer sl = (SpritesLayer) 
                settings.getGameScene().getLayer(GameConditions.OBJECTS_LAYER_ID);
        sl.addEntity(missleEntity);
        if(entity instanceof PlayerEntity)
            EntityManager.getInstance().addPlayerMissle(missleEntity);
        else 
            EntityManager.getInstance().addEnemyMissle(missleEntity);
    }
    
    private BufferedImage getImage(Missles missle) {
        BufferedImage missleImg = new BufferedImage(missle.getWidth(), 
                missle.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = missleImg.createGraphics();
        graphics.setPaint(missle.getColor());
        graphics.fillRect(0, 0, missle.getWidth(), missle.getHeight());
        return missleImg;
    }

}
