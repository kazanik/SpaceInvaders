/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import javax.swing.JFrame;
import pl.kazanik.spaceinvaders.consts.GameConditions;
import pl.kazanik.spaceinvaders.generator.SceneGenerator;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;
import pl.kazanik.spaceinvaders.entity.EnemyEntity;
import pl.kazanik.spaceinvaders.sprite.EnemySprite;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.sprite.PlayerSprite;
import pl.kazanik.spaceinvaders.scene.Scene;

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
        AbstractEntity player = new PlayerEntity(0, 0, 0, playerSprite);
        AbstractSprite enemySprite = new EnemySprite(0, 0, 0, 0, 0, null);
        AbstractEntity enemy = new EnemyEntity(0, 0, 0, enemySprite);
        player.born();
        player.move();
        player.die();
        enemy.born();
        enemy.move();
        enemy.die();
        
        SceneGenerator sg = SceneGenerator.getInstance();
        Scene gameScene = sg.generate();
        GameCanvas canvas = new GameCanvas(gameScene, player);
        JFrame gameFrame = new JFrame("Space Invaders Alpha");
        gameFrame.getContentPane().add(canvas);
        gameFrame.setSize(GameConditions.WINDOW_WIDTH, GameConditions.WINDOW_HEIGHT);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        
    }
}
