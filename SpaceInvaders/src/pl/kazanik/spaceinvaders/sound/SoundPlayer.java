/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.sound;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class SoundPlayer {
    
    public void play(final String soundPath) {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SoundManager sm = new SoundManager();
                    sm.playSound(soundPath);
                }
            }).start();
        } catch(Exception e) {
            Logger.getLogger(SoundPlayer.class.getName()).log(
                    Level.SEVERE, "error playing explosion sound", e);
        }
    }
}
