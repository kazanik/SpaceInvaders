/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import pl.kazanik.spaceinvaders.difficulty.Difficulties;
import pl.kazanik.spaceinvaders.entity.AbstractSpaceCraft;
import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.generator.PlayerGenerator;
import pl.kazanik.spaceinvaders.generator.SceneGenerator;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.settings.GameSettings;
import pl.kazanik.spaceinvaders.thread.ClientGameLoop;

/**
 *
 * @author user
 */
public class GameManager {
    
    private GameCanvas canvas;
    private PlayerEntity player;
    private Runnable gameRunnable;
    private ExecutorService clientThreadPool;

    public GameManager() {
        clientThreadPool = Executors.newFixedThreadPool(2);
    }
    
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

    public void launchGame(GameLauncher gl) {
        clientThreadPool.submit(gl);
    }
    
    public void startGameLoop() {
        gameRunnable = new ClientGameLoop(canvas, player);
        clientThreadPool.submit(gameRunnable);
    }
    
    public void abortGame() {
        clientThreadPool.shutdownNow();
    }
    
    public GameCanvas getCanvas() {
        return canvas;
    }

    public PlayerEntity getPlayer() {
        return player;
    }
    
}
