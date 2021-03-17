/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author user
 */
// class used only together with Client, not public
class EventCachingQueue {
    
    private final ArrayBlockingQueue<String> eventQueue;
    private final BufferedReader socketReader;
    private final PrintWriter socketWriter;
    private final Lock SOCKET_STREAM_LOCK;

    protected EventCachingQueue(BufferedReader socketReader, PrintWriter socketWriter,
            Lock lock) {
        eventQueue = new ArrayBlockingQueue<>(1000, true);
        this.socketReader = socketReader;
        this.socketWriter = socketWriter;
        this.SOCKET_STREAM_LOCK = lock;
    }
    
    protected  boolean pushEvent(String message) {
        boolean pushed = false;
//        if(SOCKET_STREAM_LOCK.tryLock()) {
            try {
                pushed = eventQueue.offer(message);
            } finally {
//                SOCKET_STREAM_LOCK.unlock();
            }
//        }
        return pushed;
    }
    
    protected  String pollEvent() {
        String message = "";
//        if(SOCKET_STREAM_LOCK.tryLock()) {
            try {
                message = eventQueue.poll();
            } finally {
//                SOCKET_STREAM_LOCK.unlock();
            }
//        }
        return message;
    }
    
    protected  String peekEvent() {
        String message = "";
//        if(SOCKET_STREAM_LOCK.tryLock()) {
            try {
                message = eventQueue.peek();
            } finally {
//                SOCKET_STREAM_LOCK.unlock();
            }
//        }
        return message;
    }
    
    protected  String readLine() throws IOException {
        String line = "";
//        SOCKET_STREAM_LOCK.lock();
//        if(SOCKET_STREAM_LOCK.tryLock()) {
            try {
                line = socketReader.readLine();
            } finally {
//                SOCKET_STREAM_LOCK.unlock();
            }
//        }
        return line;
    }
    
    protected  char[] readCharsToArray(char[] arr, int off, int len) throws IOException {
        if(SOCKET_STREAM_LOCK.tryLock()) {
            try {
                socketReader.read(arr, 0, len);
            } finally {
                SOCKET_STREAM_LOCK.unlock();
            }
        }
        return arr;
    }
    
    protected  void printLine(String line) {
//        if(SOCKET_STREAM_LOCK.tryLock()) {
            try {
                socketWriter.println(line);
            } finally {
//                SOCKET_STREAM_LOCK.unlock();
            }
//        }
    }
    
    protected  void printLine(int length) {
        if(SOCKET_STREAM_LOCK.tryLock()) {
            try {
                socketWriter.println(length);
            } finally {
                SOCKET_STREAM_LOCK.unlock();
            }
        }
    }
    
    protected  void writeChars(String chars) {
        if(SOCKET_STREAM_LOCK.tryLock()) {
            try {
                socketWriter.write(chars);
            } finally {
                SOCKET_STREAM_LOCK.unlock();
            }
        }
    }
    
    protected  void closeStreams() throws IOException {
        socketReader.close();
        socketWriter.close();
    }
}
