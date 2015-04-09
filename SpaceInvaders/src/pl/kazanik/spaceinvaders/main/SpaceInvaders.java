/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import pl.kazanik.spaceinvaders.difficulty.Difficulties;
import pl.kazanik.spaceinvaders.generator.SceneGenerator;
import pl.kazanik.spaceinvaders.entity.AbstractSpaceCraft;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.generator.PlayerGenerator;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.settings.GameConditions;
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
        settings.setDifficulty(Difficulties.HARD);
        SceneGenerator sg = SceneGenerator.getInstance();
        PlayerGenerator pg = PlayerGenerator.getInstance();
        Scene gameScene = sg.generate();
        settings.setGameScene(gameScene);
        AbstractSpaceCraft player = pg.generate();
        GameMenu menu = new GameMenu();
        GameCanvas canvas = new GameCanvas(gameScene, player);
        JFrame gameFrame = new JFrame("Space Invaders Beta");
        gameFrame.getContentPane().setBackground(Color.BLACK);
        gameFrame.getContentPane().add(canvas);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension location = new Dimension(scrSize.width/2-(GameConditions.WINDOW_WIDTH/2), 
                scrSize.height/2-(GameConditions.WINDOW_HEIGHT/2));
        gameFrame.setLocation(location.width, location.height);
        settings.setGameFrameLocation(location);
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
