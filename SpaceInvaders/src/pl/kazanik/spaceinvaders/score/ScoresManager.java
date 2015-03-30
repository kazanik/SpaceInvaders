/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.score;

/**
 *
 * @author kazanik
 */
public class ScoresManager {
    
    public void getScores(IScoreDao scoreDao) {
        scoreDao.loadScores();
    }
}
