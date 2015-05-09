package org.blockserver.soft.network;

import org.blockserver.soft.MinecraftPEServer;

import java.net.InetSocketAddress;

/**
 * Network Interface to handle RakNet packets.
 */
public class RakNetInterface extends Thread{

    private InetSocketAddress bindAddress;
    private boolean running = false;

    private RakNetInterface(){ }

    public static RakNetInterface getInterface(InetSocketAddress bindAddress, MinecraftPEServer server){
        RakNetInterface rakNetInterface = new RakNetInterface();
        rakNetInterface.bindAddress = bindAddress;

        return rakNetInterface;
    }

    public void startInterface(){
        if(!running){
            running = true;
            start();
        } else {
            throw new RakNetException("Can not start interface: already running.");
        }
    }

    public void stopInterface(){
        if(running){
            running = false;
            try {
                join();
            } catch (InterruptedException e) {
                throw new RakNetException(e);
            }
        } else {
            throw new RakNetException("Can not stop interface: not running.");
        }
    }

    public void run(){
        while(running){

        }
    }
}
