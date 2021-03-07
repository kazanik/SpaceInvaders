/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.entity;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.kazanik.spaceinvaders.missle.Missle;
import pl.kazanik.spaceinvaders.scene.Scene;
import pl.kazanik.spaceinvaders.scene.SpritesLayer;
import pl.kazanik.spaceinvaders.settings.GameConditions;
import pl.kazanik.spaceinvaders.utils.ObjectSerializer;

/**
 *
 * @author kazanik
 */
public class EntityManager implements Serializable {
    
    private List<AbstractSpaceCraft> enemies;
    private List<List<AbstractSpaceCraft>> enemiesWaves;
    private List<AbstractEntity> enemyMissles;
    private List<AbstractEntity> playerMissles;
    private List<AbstractSpaceCraft> players;
    private volatile AbstractSpaceCraft player;
    private static final EntityManager em = new EntityManager();
    // server
    private String serEnemiesStr, serEnemyWavesStr, serEnemyMisslesStr,
            serPlayersMisslesStr, serPlayersStr;
    // client
    private String serPlayerMisslesStr, serPlayerStr;
    private final String serEntitySeparator = ":::";
    private final String serWaveSeparator = "===";
    private final String serEntityGroupSeparator = ";;;";
    private final String serWavePrefix = ",ww,", serEnemyPrefix = ",ee,",
            serPlayerMisslePrefix = ",pm,", serEnemyMisslePrefix = ",em,",
            serPlayerPrefix = ",pp,";

    private EntityManager() {
        this.enemyMissles = new CopyOnWriteArrayList<>();
        this.enemies = new CopyOnWriteArrayList<>();
        this.playerMissles = new CopyOnWriteArrayList<>();
        this.enemiesWaves = new CopyOnWriteArrayList<>();
        this.players = new CopyOnWriteArrayList<>();
    }
    
    public static synchronized EntityManager getInstance() {
        return em;
    }
    
    public EntityManager(List<AbstractSpaceCraft> enemies) {
        this.enemies = enemies;
    }

    public List<AbstractSpaceCraft> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<AbstractSpaceCraft> enemies) {
        this.enemies = enemies;
    }
    
    public void addEnemy(AbstractSpaceCraft enemy) {
        this.enemies.add(enemy);
    }

    public List<List<AbstractSpaceCraft>> getEnemiesWaves() {
        return enemiesWaves;
    }

    public void setEnemiesWaves(List<List<AbstractSpaceCraft>> enemiesWaves) {
        this.enemiesWaves = enemiesWaves;
    }
    
    public List<AbstractSpaceCraft> getWaveEnemies(int waveNum) {
        return enemiesWaves.get(waveNum);
    }
    
    public int getWaves() {
        return enemiesWaves.size();
    }

    public List<AbstractEntity> getEnemyMissles() {
        return enemyMissles;
    }

    public void setEnemyMissles(List<AbstractEntity> missles) {
        this.enemyMissles = missles;
    }
    
    public void addEnemyMissle(AbstractEntity missle) {
        enemyMissles.add(missle);
    }
    
    public boolean removeEnemyMissle(AbstractEntity missle) {
        SpritesLayer sl = (SpritesLayer) Scene.getInstance().
                getLayer(GameConditions.OBJECTS_LAYER_ID);
        boolean succeed1 = sl.removeEntity(missle);
        boolean succeed2 = enemyMissles.remove(missle);
        return succeed1 && succeed2;
    }

    public List<AbstractEntity> getPlayerMissles() {
        return playerMissles;
    }

    public void setPlayerMissles(List<AbstractEntity> playerMissles) {
        this.playerMissles = playerMissles;
    }
    
    public void addPlayerMissle(AbstractEntity missle) {
        playerMissles.add(missle);
    }
    
    public boolean removePlayerMissle(AbstractEntity missle) {
        SpritesLayer sl = (SpritesLayer) Scene.getInstance().
                getLayer(GameConditions.OBJECTS_LAYER_ID);
        boolean succeed1 = sl.removeEntity(missle);
        boolean succeed2 = playerMissles.remove(missle);
        return succeed1 && succeed2;
    }

    public List<AbstractSpaceCraft> getPlayers() {
        return players;
    }

    public void setPlayers(List<AbstractSpaceCraft> players) {
        this.players = players;
    }
    
    public void addPlayer(AbstractSpaceCraft player) {
        players.add(player);
    }

    public void setPlayer(AbstractSpaceCraft player) {
        this.player = player;
    }
    
    public void checkDestroyedCrafts() {
        for(AbstractSpaceCraft craft : enemies) {
            if(!craft.isAlive()) destroy(craft);
        }
    }
    
    public void checkDestroyedMissles() {
        for(AbstractEntity missle : enemyMissles) {
            Missle m = (Missle) missle;
            if(m.isDestroyed()) removeEnemyMissle(missle);
        }
        for(AbstractEntity missle : playerMissles) {
            Missle m = (Missle) missle;
            if(m.isDestroyed()) removePlayerMissle(missle);
        }
    }
    
    public boolean destroy(AbstractEntity entity) {
        SpritesLayer sl = (SpritesLayer) Scene.getInstance().
                getLayer(GameConditions.OBJECTS_LAYER_ID);
        boolean succeed1 = sl.removeEntity(entity);
        boolean succeed2 = enemies.remove(entity);
        return succeed1 && succeed2;
    }
    
    public String serializeClientEntities() {
        String serEntitiesStr = "";
        serPlayerMisslesStr = "";
        serPlayerStr = "";
        try {
            // player
            serPlayerStr += serPlayerPrefix;
            serPlayerStr += ObjectSerializer.toString(player);
            // player missles
            serPlayerMisslesStr += serPlayerMisslePrefix;
            for(AbstractEntity playerMissle : player.getSpaceCraftMissles()) {
                serPlayerMisslesStr += ObjectSerializer.toString(playerMissle) 
                        + serEntitySeparator;
            }
            serPlayerMisslesStr = serPlayerMisslesStr.substring(serPlayerMisslesStr.length()
                - serEntitySeparator.length());
            // final string
            serEntitiesStr += serPlayerMisslesStr + serEntityGroupSeparator + serPlayerStr;
            serEntitiesStr += GameConditions.CONNECTION_BYE_MESSAGE;
        } catch(IOException e) {
            System.out.println("entity serialize exception");
            System.out.println(e.getMessage());
        }
        return serEntitiesStr;
    }
    
    public String serializeServerEntities() {
        serEnemiesStr = "";
        serEnemyMisslesStr = ""; 
        serEnemyWavesStr = "";
        serPlayersStr = "";
        serPlayersMisslesStr = "";
        String serEntitiesStr = "";
        try {
            // players and players missles
            serPlayersStr += serPlayerPrefix;
            serPlayersMisslesStr += serPlayerMisslePrefix;
            for(AbstractSpaceCraft player : players) {
                serPlayersStr += ObjectSerializer.toString(player)
                        + serEntitySeparator;
                for(AbstractEntity playerMissle : player.getSpaceCraftMissles()) {
                    serPlayersMisslesStr += ObjectSerializer.toString(playerMissle)
                            + serEntitySeparator;
                }
            }
            serPlayersStr = serPlayersStr.substring(serPlayersStr.length()
                - serEntitySeparator.length());
            serPlayersMisslesStr = serPlayersMisslesStr.substring(
                    serPlayersMisslesStr.length() - serEntitySeparator.length());
            // enemies
            serEnemiesStr += serEnemyPrefix;
            for(AbstractSpaceCraft enemy : enemies)
                serEnemiesStr += ObjectSerializer.toString(enemy) 
                        + serEntitySeparator;
            serEnemiesStr = serEnemiesStr.substring(serEnemiesStr.length()
                - serEntitySeparator.length());
            // enemies waves
            serEnemyWavesStr += serWavePrefix;
            for(List<AbstractSpaceCraft> enemyWave : enemiesWaves) {
                for(AbstractSpaceCraft enemy : enemyWave)
                    serEnemyWavesStr += ObjectSerializer.toString(enemy) 
                            + serEntitySeparator;
                serEnemyWavesStr = serEnemyWavesStr.substring(serEnemyWavesStr.length()
                    - serEntitySeparator.length());
                serEnemyWavesStr += serWaveSeparator;
            }
            serEnemyWavesStr = serEnemyWavesStr.substring(serEnemyWavesStr.length()
                - serWaveSeparator.length());
            // enemies missles
            serEnemyMisslesStr += serEnemyMisslePrefix;
            for(AbstractEntity enemyMissle : enemyMissles)
                serEnemyMisslesStr += ObjectSerializer.toString(enemyMissle) 
                        + serEntitySeparator;
            serEnemyMisslesStr = serEnemyMisslesStr.substring(serEnemyMisslesStr.length()
                - serEntitySeparator.length());
            // final string
            serEntitiesStr += serEnemiesStr + serEntityGroupSeparator + 
                    serEnemyWavesStr + serEntityGroupSeparator + serEnemyMisslesStr
                    + serEntityGroupSeparator + serPlayersStr 
                    + serEntityGroupSeparator + serPlayersMisslesStr;
            serEntitiesStr += GameConditions.CONNECTION_BYE_MESSAGE;
        } catch(IOException e) {
            System.out.println("entity serialize exception");
            System.out.println(e.getMessage());
        }
        return serEntitiesStr;
    }
    
    public void deserializeEntities(String serEntitiesStr) {
        List<AbstractSpaceCraft> tmpEnemies = new CopyOnWriteArrayList<>(/*enemies*/);
        List<List<AbstractSpaceCraft>> tmpEnemiesWaves = new CopyOnWriteArrayList<>(/*enemiesWaves*/);
        List<AbstractEntity> tmpEnemyMissles = new CopyOnWriteArrayList<>(/*enemyMissles*/);
        List<AbstractEntity> tmpPlayerMissles = new CopyOnWriteArrayList<>(/*playerMissles*/);
//        enemies = new CopyOnWriteArrayList<>();
//        enemiesWaves = new CopyOnWriteArrayList<>();
//        enemyMissles = new CopyOnWriteArrayList<>();
//        playerMissles = new CopyOnWriteArrayList<>();
        try {
            String[] serEntityGroups = serEntitiesStr.split(serEntityGroupSeparator);
            for(String serEntityGroup : serEntityGroups) {
                String groupPrefix = serEntityGroup.substring(0, serEnemyPrefix.length());
                serEntityGroup = serEntityGroup.substring(serEnemyPrefix.length());
                if(groupPrefix.equalsIgnoreCase(serWavePrefix)) {
                    String[] waveGroups = serEntityGroup.split(serWaveSeparator);
                    for(String wave : waveGroups) {
                        List<AbstractSpaceCraft> enemyWave = new CopyOnWriteArrayList<>();
                        for(Object entity : parseSerStr(wave)) {
                            if(entity instanceof AbstractSpaceCraft)
                                enemyWave.add((AbstractSpaceCraft) entity);
                        }
//                        enemiesWaves.add(enemyWave);
                        tmpEnemiesWaves.add(enemyWave);
                    }
                } else {
                    for(Object entity : parseSerStr(serEntityGroup)) {
                        if(entity instanceof AbstractSpaceCraft &&
                            groupPrefix.matches(serEnemyPrefix)) {
//				enemies.add((AbstractSpaceCraft) entity);
                                tmpEnemies.add((AbstractSpaceCraft) entity);
                        } else if(entity instanceof AbstractEntity &&
                            groupPrefix.matches(serEnemyMisslePrefix)) {
//				enemyMissles.add((AbstractEntity) entity);
                                tmpEnemyMissles.add((AbstractEntity) entity);
                        } else if(entity instanceof AbstractEntity && 
                            groupPrefix.matches(serPlayerMisslePrefix)) {
//				playerMissles.add((AbstractEntity) entity);
                                tmpPlayerMissles.add((AbstractEntity) entity);
                        }
                    }
                }
            }
            enemies = new ArrayList<>(tmpEnemies);
            enemiesWaves = new ArrayList<>(tmpEnemiesWaves);
            enemyMissles = new ArrayList<>(tmpEnemyMissles);
//            playerMissles = new ArrayList<>(tmpPlayerMissles);
            playerMissles.addAll(tmpPlayerMissles);
        } catch(IOException | ClassNotFoundException e) {
            Logger.getLogger(EntityManager.class.getName()).log(
                    Level.SEVERE, "exception deserializing entities", e);
        }
    }
    
    private Object[] parseSerStr(String serGroup) throws IOException, ClassNotFoundException {
        // parse either entity str or single wave str
        String[] serEntityTab = serGroup.split(serEntitySeparator);
        Object[] entities = new Object[serEntityTab.length];
        try {
            int i = 0;
            for(String serEntity : serEntityTab)
                entities[i] = ObjectSerializer.fromString(serEntity);
            return entities;
        } catch (IOException|ClassNotFoundException ex) {
            Logger.getLogger(EntityManager.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
