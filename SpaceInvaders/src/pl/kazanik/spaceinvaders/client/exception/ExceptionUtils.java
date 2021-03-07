/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.client.exception;

import java.io.IOException;
import java.net.SocketTimeoutException;

/**
 *
 * @author user
 */
public class ExceptionUtils {
    
    // see if provided exception root cause is subclass of IOException
    public static boolean isRootCauseIOEx(Throwable t) {
        return (t instanceof IOException) ? true : (t == null) 
                ? false : isRootCauseIOEx(t.getCause());
    }
    
    // see if provided exception root cause is subclass of ClientDisconnectedException
    public static boolean isRootCauseCDEx(Throwable t) {
        return (t instanceof ClientDisconnectedException) ? true : (t == null) 
                ? false : isRootCauseCDEx(t.getCause());
    }
    
    public static Throwable getCauseCDEx(Throwable t) {
        return (t.getCause() instanceof ClientDisconnectedException) ? 
                t : getCauseCDEx(t.getCause());
    }
    
    // see if provided exception root cause is subclass of ClientDisconnectedException
    public static boolean isCausedBySoTimeoutEx(Throwable t) {
        return (t instanceof SocketTimeoutException) ? true : (t == null) 
                ? false : isCausedBySoTimeoutEx(t.getCause());
    }
    
    // see if provided exception root cause is subclass of ClientDisconnectedException
    public static boolean isCausedByIOEx(Throwable t) {
        return (t instanceof IOException) ? true : (t == null) 
                ? false : isCausedByIOEx(t.getCause());
    }
}
