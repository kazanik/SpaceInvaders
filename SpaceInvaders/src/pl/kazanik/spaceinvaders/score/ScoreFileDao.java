/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.score;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import pl.kazanik.spaceinvaders.settings.GameConditions;

/**
 *
 * @author kazanik
 */
public class ScoreFileDao implements IScoreDao {

    @Override
    public void saveScore(Score score) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(GameConditions.SCORES_FILE_PATH, true);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(score);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    @Override
    public List<Score> loadScores() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Score> scores = new ArrayList<>();
        try {
            fis = new FileInputStream(GameConditions.SCORES_FILE_PATH);
            ois = new ObjectInputStream(fis);
            Score score;
            while((score = (Score) ois.readObject()) != null) {
                scores.add(score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                return scores;
            }
        }
    }
    
}
