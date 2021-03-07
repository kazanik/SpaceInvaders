/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.client;

/**
 *
 * @author user
 */
public class SessionManager {
    
    private volatile String clientToken;

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }
    
    public void clearClientToken() {
        clientToken = "";
    }
}
