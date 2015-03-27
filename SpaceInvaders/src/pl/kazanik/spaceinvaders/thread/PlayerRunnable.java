/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.thread;

import pl.kazanik.spaceinvaders.entity.PlayerEntity;
import pl.kazanik.spaceinvaders.main.GameLoop;

/**
 *
 * @author kazanik
 */
public class PlayerRunnable implements Runnable {

    private GameLoop gameLoop;
    private PlayerEntity player;

    public PlayerRunnable() {
    }

    public PlayerRunnable(GameLoop gameLoop, PlayerEntity player) {
        this.gameLoop = gameLoop;
        this.player = player;
    }
    
    @Override
    public void run() {
        System.out.println("Player runnable");
        while(gameLoop.isRunning()) {
            if(player.getLastMoveFrame()+player.getSpeed() == gameLoop.getFrames()) {
                player.doAction();
//                player.setLastMoveFrame(frames);
                player.setLastMoveFrame(gameLoop.getFrames());
            }
        }
    }
    
}
