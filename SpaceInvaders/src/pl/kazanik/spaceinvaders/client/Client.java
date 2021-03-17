/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author user
 */
public class Client {
    
    private String token;
    private final Socket socket;
    private final EventCachingQueue inMessageQueue, outMessageQueue;
//    private volatile long lastHeartBeat;
    private AtomicLong lastHeartBeat;
    private final Lock SOCKET_IN_STREAM_LOCK, SOCKET_OUT_STREAM_LOCK;
    private boolean tokenSaved;

    public Client(String token, Socket socket, AtomicLong lastHeartBeat, 
            BufferedReader in, PrintWriter out, Lock inLock, Lock outLock) {
        this.token = token;
        this.socket = socket;
        this.lastHeartBeat = lastHeartBeat;
        this.inMessageQueue = new EventCachingQueue(in, out, inLock);
        this.outMessageQueue = new EventCachingQueue(in, out, outLock);
        this.SOCKET_IN_STREAM_LOCK = inLock;
        this.SOCKET_OUT_STREAM_LOCK = outLock;
    }

    public void setLastHeartBeat(long lastHeartBeat) {
        if(Long.compare(lastHeartBeat, this.lastHeartBeat.longValue()) > 0) {
            this.lastHeartBeat.set(lastHeartBeat);
            System.out.println("set");
        }
    }

    public void setToken(String token) {
        this.token = token;
        tokenSaved = true;
    }

    public String getToken() {
        return token;
    }

    public Socket getSocket() {
        return socket;
    }

    public long getLastHeartBeat() {
        return lastHeartBeat.longValue();
    }

    public boolean isTokenSaved() {
        return tokenSaved;
    }

    public boolean tryLockSocketOutStream() {
        return SOCKET_OUT_STREAM_LOCK.tryLock();
    }
    
    public void unLockSocketOutStream() {
        SOCKET_OUT_STREAM_LOCK.unlock();
    }

    // IN
    public /*synchronized*/ boolean pushInMessage(String message) {
        boolean pushed = false;
        if(SOCKET_IN_STREAM_LOCK.tryLock()) {
            try {
                pushed = inMessageQueue.pushEvent(message);
            } finally {
                SOCKET_IN_STREAM_LOCK.unlock();
            }
        }
        return pushed;
    }
    
    // OUT
    public /*synchronized*/ boolean pushOutMessage(String message) {
        boolean pushed = false;
        if(SOCKET_OUT_STREAM_LOCK.tryLock()) {
            try {
                pushed = outMessageQueue.pushEvent(message);
            } finally {
                SOCKET_OUT_STREAM_LOCK.unlock();
            }
        }
        return pushed;
    }
    
    // IN
    public /*synchronized*/ String pollInMessage() {
        String message = "";
        if(SOCKET_IN_STREAM_LOCK.tryLock()) {
            try {
                message = inMessageQueue.pollEvent();
            } finally {
                SOCKET_IN_STREAM_LOCK.unlock();
            }
        }
        return message;
    }
    
    // OUT
    public /*synchronized*/ String pollOutMessage() {
        String message = "";
        if(SOCKET_OUT_STREAM_LOCK.tryLock()) {
            try {
                message = outMessageQueue.pollEvent();
            } finally {
                SOCKET_OUT_STREAM_LOCK.unlock();
            }
        }
        return message;
    }
    
    // IN
    public /*synchronized*/ String peekInMessage() {
        String message = "";
        if(SOCKET_IN_STREAM_LOCK.tryLock()) {
            try {
                message = inMessageQueue.peekEvent();
            } finally {
                SOCKET_IN_STREAM_LOCK.unlock();
            }
        }
        return message;
    }
    
    // OUT
    public /*synchronized*/ String peekOutMessage() {
        String message = "";
        //if(SOCKET_OUT_STREAM_LOCK.tryLock()) {
            try {
                message = outMessageQueue.peekEvent();
            } finally {
                //SOCKET_OUT_STREAM_LOCK.unlock();
            }
        //}
        return message;
    }
    
    public /*synchronized*/ String readLine() throws IOException {
//        System.out.println("client readl");
        String line = "";
//        SOCKET_IN_STREAM_LOCK.lock();
        if(SOCKET_IN_STREAM_LOCK.tryLock()) {
            try {
                line = inMessageQueue.readLine();
            } finally {
                SOCKET_IN_STREAM_LOCK.unlock();
            }
        }
        return line;
        //return messageQueue.readLine();
    }
    
    public /*synchronized*/ char[] readCharsToArray(char[] arr, int off, int len) 
            throws IOException {
        //System.out.println("client readc");
        char[] buffer = new char[]{};
        //if(SOCKET_IN_STREAM_LOCK.tryLock()) {
            try {
                buffer = inMessageQueue.readCharsToArray(arr, off, len);
            } finally {
                //SOCKET_IN_STREAM_LOCK.unlock();
            }
        //}
        return buffer;
        //return messageQueue.readCharsToArray(arr, off, len);
    }
    
    public /*synchronized*/ void printLine(String line) {
        //System.out.println("client printl");
        if(SOCKET_OUT_STREAM_LOCK.tryLock()) {
            try {
                outMessageQueue.printLine(line);
            } finally {
                SOCKET_OUT_STREAM_LOCK.unlock();
            }
        }
        //messageQueue.printLine(line);
    }
    
    public /*synchronized*/ void printLine(int length) {
        //if(SOCKET_OUT_STREAM_LOCK.tryLock()) {
            try {
                outMessageQueue.printLine(length);
            } finally {
                //SOCKET_OUT_STREAM_LOCK.unlock();
            }
        //}
        //messageQueue.printLine(length);
    }
    
    public /*synchronized*/ void writeChars(String chars) {
        //System.out.println("client write");
        //if(SOCKET_OUT_STREAM_LOCK.tryLock()) {
            try {
                outMessageQueue.writeChars(chars);
            } finally {
                //SOCKET_OUT_STREAM_LOCK.unlock();
            }
        //}
        //messageQueue.writeChars(chars);
    }
    
    public /*synchronized*/ void closeStreams() throws IOException/*, InterruptedException*/ {
        inMessageQueue.closeStreams();
        outMessageQueue.closeStreams();
    }

    public void closeSocket() throws IOException {
        if(socket != null)
            socket.close();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.token);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
        if (obj == null || !(obj instanceof Client)) {
            return false;
        }
        final Client other = (Client) obj;
        if (!this.token.equals(other.getToken())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "token=" + token + ", socket=" + socket 
                + ", lastHeartBeat=" + lastHeartBeat + ", tokenSaved=" + tokenSaved + '}';
    }
    
}
