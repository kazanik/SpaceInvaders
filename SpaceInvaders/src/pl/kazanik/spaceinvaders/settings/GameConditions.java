/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.settings;

import java.util.regex.Pattern;

/**
 *
 * @author kazanik
 */
public class GameConditions {
    
    // gaps / dimensions
    public static final int WINDOW_WIDTH = 768;
    public static final int WINDOW_HEIGHT = 548;
    public static final int SCENE_WIDTH = 640;
    public static final int SCENE_HEIGHT = 548;
    public static final int SCENE_LAYERS = 3;
    public static final int SCENE_HORIZONTAL_GAP = 64;
    public static final int SCENE_VERTICAL_GAP = 0;
    public static final int WAVE_GAP = 150;
    public static final int PLAYER_SPRITE_WIDTH = 50;
    public static final int PLAYER_SPRITE_HEIGHT = 50;
    public static final int ENEMY_SPRITE_WIDTH = 50;
    public static final int ENEMY_SPRITE_HEIGHT = 50;
    // scene layers
    public static final int BG_LAYER_ID = 0;
    public static final int OBJECTS_LAYER_ID = 1;
    public static final int EFFECTS_LAYER_ID = 2;
    // client / server delays
    // refresh scene every 20 ms
    public static final long SCENE_REFRESH_RATE = 20;
    // client send/receive packets to server every x ms
    public static final long CLIENT_SYNCH_DELAY = 40;  // was 20
    // server send/receive packets to server every x ms
    public static final long SERVER_SYNCH_DELAY2 = 20;  // was 10
    // client send heartbeat to server every 1 seconds
    public static final long CLIENT_MAX_IDLE_TIME = 10_000l;   // 1000*10
    // resources
    public static final String PLAYER_SPRITE_PATH = 
            "resources/sprites/space_ship1_sprite.png";
    public static final String PHOENIX_SPRITE_PATH = 
            "resources/sprites/space_ship2_r_sprite.png";
    public static final String SCORES_FILE_PATH = "scores";
    // sounds
    public static final String EXPLOSION_SOUND_PATH = 
            "resources\\sounds\\8bit_bomb_explosion.wav";
    public static final String CANNON_MISSLE_SOUND_PATH = 
            "resources\\sounds\\laser1.wav";
    // key codes
    public static final int FIRE_KEY_CODE = 17, FIRE_KEY_CODE2 = 32;
    public static final int RIGHT_KEY_CODE = 39, RIGHT_KEY_CODE2 = 68;
    public static final int LEFT_KEY_CODE = 37, LEFT_KEY_CODE2 = 65;
    // server info
    public static final String SERVER_NAME = "192.168.0.100";
    public static final int SERVER_PORT = 4444;
    // message separators
    public static final String SERVER_MODE_HEARTBEAT = "mode-heartbeat";
    public static final String SERVER_MODE_SEND = "mode-update-send";
    public static final String SERVER_MODE_RECEIVE = "mode-update-receive";
    public static final String CONNECTION_BYE_MESSAGE = "Bye,BYE.";
    public static final String MESSAGE_FRAGMENT_SEPARATOR = "!<>!";
    // token
    public static final String CLIENT_TOKEN_PREFIX = "###";
    public static final String CLIENT_TOKEN_SUFFIX = "###";
    public static final String CLIENT_TOKEN_BODY = "Client#";
    public static final Pattern TOKEN_PATTERN = Pattern.compile(".*" +
            GameConditions.CLIENT_TOKEN_PREFIX + GameConditions.CLIENT_TOKEN_BODY
            + "\\d+" + GameConditions.CLIENT_TOKEN_SUFFIX + ".*");
    // cpu cores
    public static final int CPU_CORES_COUNT = Runtime.getRuntime().availableProcessors();
    // server task types
    public static final String LISTENER_TASK = "LISTENER-TASK";
    public static final String UPDATE_TASK = "UPDATE-TASK";
    public static final String HEARTBEAT_TASK = "HEARTBEAT-TASK";
    public static final String PRINTER_TASK = "PRINTER-TASK";
}
