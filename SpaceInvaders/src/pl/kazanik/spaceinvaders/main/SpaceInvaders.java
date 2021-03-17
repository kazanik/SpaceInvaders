/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import pl.kazanik.spaceinvaders.client.SessionManager;

/**
 *
 * @author kazanik
 */
public class SpaceInvaders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GameManager gameManager = new GameManager();
        SessionManager session = new SessionManager();
//        GameLauncher gl = new GameLauncher(canvas, (PlayerEntity) player, session);
        GameLauncher gl = new GameLauncher(session, gameManager);
        gameManager.initGame();
        gameManager.launchGame(gl);
//        Thread mainThread = new Thread(gl);
//        mainThread.start();
        //gl.init();
        //gl.start();
        
//        int test = 16;
//        test += (test > 15) ? 0 : test;
//        System.out.println(test);
//        AbstractSprite sprite1 = new EnemySprite(0, 0, 0, 0, 0, null);
//        AbstractSpaceCraft Phoenix = new EnemyEntity(0, 0, 0, 0, 0, 0, sprite1);
//        AbstractEntity enemy1 = new EnemyEntity(0, 0, 0, sprite1);
//        AbstractSprite sprite2 = new EnemySprite(0, 0, 0, 10, 0, null);
//        AbstractEntity enemy2 = new EnemyEntity(0, 0, 0, sprite2);
//        System.out.println(enemy1.equals(enemy2));
    }
}
