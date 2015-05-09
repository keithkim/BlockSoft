package org.blockserver.soft.network.raknet.packets;

import org.blockserver.soft.network.raknet.RakNetPacket;
import org.blockserver.soft.network.raknet.RakNetPackets;

import java.nio.ByteBuffer;
import java.util.Random;

/**
 * Created by jython234 on 5/8/2015.
 */
public class UnconnectedPingPacket extends RakNetPacket{
    public long pingID;
    public long serverID;
    public final String identifier = "MCCPP;Demo;";
    public String serverName;

    @Override
    protected void _encode(ByteBuffer bb) {
        bb.put(RakNetPackets.ID_UNCONNECTED_PING_OPEN_CONNECTIONS);
        bb.putLong(pingID);
        bb.putLong(RakNetPackets.SERVER_ID);
        bb.put(RakNetPackets.MAGIC);

        String total = identifier + serverName;
        bb.putShort((short) total.getBytes().length);
        bb.put(total.getBytes());

    }

    @Override
    public int getLength() {
        return 35 + identifier.getBytes().length + serverName.getBytes().length;
    }
}
