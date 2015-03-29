/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.util.List;
import javax.swing.JFrame;
import pl.kazanik.spaceinvaders.difficulty.Difficulties;
import pl.kazanik.spaceinvaders.generator.SceneGenerator;
import pl.kazanik.spaceinvaders.entity.AbstractEntity;
import pl.kazanik.spaceinvaders.entity.AbstractSpaceCraft;
import pl.kazanik.spaceinvaders.entity.EnemyEntity;
import pl.kazanik.spaceinvaders.entity.EntityManager;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.generator.EnemyGenerator;
import pl.kazanik.spaceinvaders.generator.PlayerGenerator;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.settings.GameSettings;
import pl.kazanik.spaceinvaders.sprite.AbstractSprite;
import pl.kazanik.spaceinvaders.sprite.EnemySprite;

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
        settings.setDifficulty(Difficulties.MEDIUM);
        SceneGenerator sg = SceneGenerator.getInstance();
        PlayerGenerator pg = PlayerGenerator.getInstance();
        Scene gameScene = sg.generate();
        settings.setGameScene(gameScene);
        AbstractSpaceCraft player = pg.generate();
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
        
//        int test = 16;
//        test += (test > 15) ? 0 : test;
//        System.out.println(test);
//        AbstractSprite sprite1 = new EnemySprite(0, 0, 0, 0, 0, null);
//        AbstractSpaceCraft Phoenix = new EnemyEntity(0, 0, 0, 0, 0, 0, sprite1);
//        AbstractEntity enemy1 = new EnemyEntity(0, 0, 0, sprite1);
//        AbstractSprite sprite2 = new EnemySprite(0, 0, 0, 10, 0, null);
//        AbstractEntity enemy2 = new EnemyEntity(0, 0, 0, sprite2);
//        System.out.println(enemy1.equals(enemy2));
    }
}
