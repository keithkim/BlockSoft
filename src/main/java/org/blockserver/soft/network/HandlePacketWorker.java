package org.blockserver.soft.network;

import org.blockserver.soft.network.raknet.RakNetPackets;
import org.blockserver.soft.network.raknet.packets.ConnectedPingPacket;
import org.blockserver.soft.network.raknet.packets.UnconnectedPingPacket;
import org.blockserver.soft.util.Worker;

import java.io.IOException;
import java.net.DatagramPacket;

/**
 * Worker that is designed to handle datagram packets from the RakNetInterface.
 */
public class HandlePacketWorker extends Worker{
    private DatagramPacket packet;
    private RakNetInterface rakNetInterface;

    public HandlePacketWorker(String name, DatagramPacket toHandle, RakNetInterface rakNetInterface) {
        super(name);
        packet = toHandle;
        this.rakNetInterface = rakNetInterface;
    }

    @Override
    public void run() {
        byte packetId = packet.getData()[0];
        rakNetInterface.getServer().getLogger().debug("Handling packet: " + packetId + ", from: " + packet.getSocketAddress().toString());
        switch (packetId){
            case RakNetPackets.ID_CONNECTED_PING_OPEN_CONNECTIONS:
                ConnectedPingPacket cpp = new ConnectedPingPacket();
                cpp.decode(packet.getData());

                UnconnectedPingPacket upp = new UnconnectedPingPacket();
                upp.pingID = cpp.pingId;
                upp.serverID = 0;
                upp.serverName = "BlockSoft Demo";

                try {
                    rakNetInterface.sendBytes(upp.encode(), packet.getSocketAddress());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
