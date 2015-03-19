/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.generator.SceneGenerator;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;
import pl.kazanik.spaceinvaders.entity.EnemyEntity;
import pl.kazanik.spaceinvaders.sprite.EnemySprite;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.factory.EntityFactory;
import pl.kazanik.spaceinvaders.generator.EnemyGenerator;
import pl.kazanik.spaceinvaders.generator.PlayerGenerator;
import pl.kazanik.spaceinvaders.sprite.PlayerSprite;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.settings.GameSettings;

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
        GameSettings settings = GameSettings.getInstance();
        SceneGenerator sg = SceneGenerator.getInstance();
        PlayerGenerator pg = PlayerGenerator.getInstance();
        Scene gameScene = sg.generate();
        settings.setGameScene(gameScene);
        AbstractEntity player = pg.generate();
        EnemyGenerator eg = EnemyGenerator.getInstance();
        List<AbstractEntity> enemies = eg.generate();
        GameCanvas canvas = new GameCanvas(gameScene, player);
        JFrame gameFrame = new JFrame("Space Invaders Alpha");
//        gameFrame.setSize(GameConditions.WINDOW_WIDTH, GameConditions.WINDOW_HEIGHT);
//        gameFrame.setMinimumSize(new Dimension(GameConditions.WINDOW_WIDTH, 
//                GameConditions.WINDOW_HEIGHT));
//        gameFrame.setMaximumSize(new Dimension(GameConditions.WINDOW_WIDTH, 
//                GameConditions.WINDOW_HEIGHT));
//        gameFrame.setExtendedState(JFrame.NORMAL);
        gameFrame.getContentPane().add(canvas);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);
        gameFrame.setResizable(false);
        GameLoop gl = new GameLoop(canvas, enemies);
        gl.start();
    }
}
