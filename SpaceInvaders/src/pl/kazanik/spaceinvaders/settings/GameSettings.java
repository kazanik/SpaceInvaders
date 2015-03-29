/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.settings;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import pl.kazanik.spaceinvaders.difficulty.Difficulties;
import pl.kazanik.spaceinvaders.scene.Scene;

/**
 *
 * @author kazanik
 */
public class GameSettings {
    
    private Difficulties difficulty;
    private Scene gameScene;
    private static final GameSettings settings = new GameSettings();

    private GameSettings() {
        
    }

//    public GameSettings(Difficulties difficulty) {
//        this.difficulty = difficulty;
//    }
    public static GameSettings getInstance() {
        return settings;
    }

    public Difficulties getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulties difficulty) {
        this.difficulty = difficulty;
    }

    public Scene getGameScene() {
        return gameScene;
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

}
