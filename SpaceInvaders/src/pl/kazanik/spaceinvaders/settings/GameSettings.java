/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.settings;

import java.awt.Dimension;
import java.util.List;
import pl.kazanik.spaceinvaders.difficulty.Difficulties;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.score.Score;

/**
 *
 * @author kazanik
 */
public class GameSettings {
    
    private Difficulties difficulty;
    private Scene gameScene;
    private Dimension gameFrameLocation;
    private List<Score> scores;
    private static final GameSettings settings = new GameSettings();

    private GameSettings() {
        
    }

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

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public Dimension getGameFrameLocation() {
        return gameFrameLocation;
    }

    public void setGameFrameLocation(Dimension gameFrameLocation) {
        this.gameFrameLocation = gameFrameLocation;
    }

}
