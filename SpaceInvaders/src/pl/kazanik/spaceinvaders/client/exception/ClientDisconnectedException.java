/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.client.exception;

import java.io.IOException;

/**
 *
 * @author user
 */
public class ClientDisconnectedException extends IOException {

    private static final String EX_DESC = "client socket disconnected ioex";
    private final String clientToken;
    private final String exLocation;
    
    public ClientDisconnectedException() {
        // for testing purposes only
        super();
        this.clientToken = "";
        this.exLocation = "";
    }

    public ClientDisconnectedException(String clientToken, String location, 
            String message, Throwable cause) {
        super(message == null ? EX_DESC : message, cause);
        this.clientToken = clientToken;
        this.exLocation = location;
    }
    
    @Override
    public String toString() {
        return "ClientDisconnectedException{" + "clientToken=" + clientToken 
                + ", description=" + EX_DESC + ", location=" + exLocation + '}';
    }
    
}
