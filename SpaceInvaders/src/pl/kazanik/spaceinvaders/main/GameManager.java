/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import pl.kazanik.spaceinvaders.difficulty.Difficulties;
import pl.kazanik.spaceinvaders.entity.AbstractSpaceCraft;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.generator.PlayerGenerator;
import pl.kazanik.spaceinvaders.generator.SceneGenerator;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.settings.GameSettings;

/**
 *
 * @author user
 */
public class GameManager {
    
    private GameCanvas canvas;
    private PlayerEntity player;
    
    public void initGame() {
        Difficulties gameDifficulty = Difficulties.EASY;
        GameSettings settings = GameSettings.getInstance();
        settings.setDifficulty(gameDifficulty);
        SceneGenerator sg = new SceneGenerator();
        PlayerGenerator pg = new PlayerGenerator();
        Scene gameScene = sg.generate();
        settings.setGameScene(gameScene);
        player = (PlayerEntity) pg.generate();
        GameMenu menu = new GameMenu();
        canvas = new GameCanvas(gameScene, player);
        JFrame gameFrame = new JFrame("Space Invaders Alpha");
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
    }

    public GameCanvas getCanvas() {
        return canvas;
    }

    public PlayerEntity getPlayer() {
        return player;
    }
    
}
