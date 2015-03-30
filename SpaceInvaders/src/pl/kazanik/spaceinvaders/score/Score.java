/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.score;

import java.io.Serializable;

/**
 *
 * @author kazanik
 */
public class Score implements Serializable {
    
    private int score;
    private int invadersDestroyed;
    private int misslesFired;
    private long playTime;
    private String difficultyName;
    private String dateTime;

    public Score() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getInvadersDestroyed() {
        return invadersDestroyed;
    }

    public void setInvadersDestroyed(int invadersDestroyed) {
        this.invadersDestroyed = invadersDestroyed;
    }

    public int getMisslesFired() {
        return misslesFired;
    }

    public void setMisslesFired(int misslesFired) {
        this.misslesFired = misslesFired;
    }

    public long getPlayTime() {
        return playTime;
    }

    public void setPlayTime(long time) {
        this.playTime = time;
    }

    public String getDifficultyName() {
        return difficultyName;
    }

    public void setDifficultyName(String difficultyName) {
        this.difficultyName = difficultyName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return new StringBuffer("").append(score).append(";")
                .append(invadersDestroyed).append(";")
                .append(misslesFired).append(";")
                .append(playTime).append(";").append(difficultyName)
                .append(";").append(dateTime)
                .append("\n").toString();
    }
    
}
