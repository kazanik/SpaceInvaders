/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.settings;

/**
 *
 * @author kazanik
 */
public class GameConditions {
    
    // static fields
    public static final int WINDOW_WIDTH = 768;
    public static final int WINDOW_HEIGHT = 480;
    public static final int SCENE_WIDTH = 640;
    public static final int SCENE_HEIGHT = 480;
    public static final int SCENE_LAYERS = 3;
    public static final int SCENE_HORIZONTAL_GAP = 64;
    public static final int SCENE_VERTICAL_GAP = 0;
    public static final int BG_LAYER_ID = 0;
    public static final int OBJECTS_LAYER_ID = 1;
    public static final int EFFECTS_LAYER_ID = 2;
    public static final long REFRESH_RATE = 20;
    public static final int WAVE_GAP = 150;
    public static final int PLAYER_SPRITE_WIDTH = 50;
    public static final int PLAYER_SPRITE_HEIGHT = 50;
    public static final int ENEMY_SPRITE_WIDTH = 50;
    public static final int ENEMY_SPRITE_HEIGHT = 50;
    public static final String PLAYER_SPRITE_PATH = 
            "resources/sprites/space_ship1_sprite.png";
    public static final String PHOENIX_SPRITE_PATH = 
            "resources/sprites/space_ship2_r_sprite.png";
    public static final String SCORES_FILE_PATH = "scores";
    public static final int FIRE_KEY_CODE = 17, FIRE_KEY_CODE2 = 32;
    public static final int RIGHT_KEY_CODE = 39, RIGHT_KEY_CODE2 = 68;
    public static final int LEFT_KEY_CODE = 37, LEFT_KEY_CODE2 = 65;
}
