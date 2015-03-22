/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import pl.kazanik.spaceinvaders.difficulty.Difficulty;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.generator.SceneGenerator;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;
import pl.kazanik.spaceinvaders.entity.EnemyEntity;
import pl.kazanik.spaceinvaders.entity.EnemyManager;
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
        settings.setDifficulty(Difficulty.HARD);
        SceneGenerator sg = SceneGenerator.getInstance();
        PlayerGenerator pg = PlayerGenerator.getInstance();
        Scene gameScene = sg.generate();
        settings.setGameScene(gameScene);
        AbstractEntity player = pg.generate();
        EnemyGenerator eg = EnemyGenerator.getInstance();
        List<AbstractEntity> enemies = eg.generate();
        EnemyManager em = EnemyManager.getInstance();
        em.setEnemies(enemies);
        GameCanvas canvas = new GameCanvas(gameScene, player);
        JFrame gameFrame = new JFrame("Space Invaders Alpha");
        gameFrame.getContentPane().add(canvas);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);
        gameFrame.setResizable(false);
        GameLoop gl = new GameLoop(canvas, (PlayerEntity) player);
        gl.init();
        gl.start();
//        AbstractSprite sprite1 = new EnemySprite(0, 0, 0, 0, 0, null);
//        AbstractEntity enemy1 = new EnemyEntity(0, 0, 0, sprite1);
//        AbstractSprite sprite2 = new EnemySprite(0, 0, 0, 10, 0, null);
//        AbstractEntity enemy2 = new EnemyEntity(0, 0, 0, sprite2);
//        System.out.println(enemy1.equals(enemy2));
    }
}
