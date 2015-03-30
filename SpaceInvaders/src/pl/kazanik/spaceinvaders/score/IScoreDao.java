/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.score;

import java.util.List;

/**
 *
 * @author kazanik
 */
public interface IScoreDao {
    
    public abstract void saveScore(Score score);
    public abstract List<Score> loadScores();
}
