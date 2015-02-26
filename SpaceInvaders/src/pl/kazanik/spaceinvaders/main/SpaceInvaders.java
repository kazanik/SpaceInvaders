/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import pl.kazanik.spaceinvaders.imodel.AbstractEntity;
import pl.kazanik.spaceinvaders.imodel.AbstractSprite;
import pl.kazanik.spaceinvaders.model.EnemyEntity;
import pl.kazanik.spaceinvaders.model.EnemySprite;
import pl.kazanik.spaceinvaders.model.PlayerEntity;
import pl.kazanik.spaceinvaders.model.PlayerSprite;

/**
 *
 * @author kazanik
 */
public class SpaceInvaders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AbstractSprite playerSprite = new PlayerSprite(0, 0, 0, 0, 0, null);
        AbstractEntity player = new PlayerEntity(0, 0, playerSprite);
        AbstractSprite enemySprite = new EnemySprite(0, 0, 0, 0, 0, null);
        AbstractEntity enemy = new EnemyEntity(0, 0, enemySprite);
        player.born();
        player.move();
        player.die();
        enemy.born();
        enemy.move();
        enemy.die();
    }
}
