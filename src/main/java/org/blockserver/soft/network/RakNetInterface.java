package org.blockserver.soft.network;

import org.blockserver.soft.MinecraftPEServer;
import org.blockserver.soft.util.Worker;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

/**
 * Network Interface to handle RakNet packets.
 */
public class RakNetInterface extends Thread{

    private InetSocketAddress bindAddress;
    private DatagramSocket socket;
    private boolean running = false;

    private MinecraftPEServer server;

    private RakNetInterface(){ }

    public static RakNetInterface getInterface(InetSocketAddress bindAddress, MinecraftPEServer server){
        RakNetInterface rakNetInterface = new RakNetInterface();
        rakNetInterface.bindAddress = bindAddress;
        rakNetInterface.server = server;

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
        setName("RakNetInterface");
        server.getLogger().info("Starting RakNetInterface on "+bindAddress.toString());

        try {
            socket = new DatagramSocket(bindAddress.getPort());
            while(running){
                byte[] buffer = new byte[2048];
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

                socket.setSoTimeout(2000);
                socket.setBroadcast(true);
                try{
                    socket.receive(dp);

                    dp.setData(Arrays.copyOf(dp.getData(), dp.getLength())); //Strip extra bytes

                    new HandlePacketWorker("PacketHandler", dp, this).startWorker();
                } catch (SocketTimeoutException e){

                } catch (IOException e) {
                    server.getLogger().error("IOException while receiving packets in RakNetInterface.");
                    throw new RakNetException(e);
                }

            }
        } catch (SocketException e) {
            throw new RakNetException("Failed to bind to port: "+e.getMessage());
        }
    }

    public void sendBytes(byte[] buffer, SocketAddress client) throws IOException {
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, client);
        socket.send(dp);
    }

    public MinecraftPEServer getServer(){
        return server;
    }
}
