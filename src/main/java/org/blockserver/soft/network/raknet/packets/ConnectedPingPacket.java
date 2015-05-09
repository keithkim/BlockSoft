package org.blockserver.soft.network.raknet.packets;

import org.blockserver.soft.network.raknet.RakNetPacket;
import org.blockserver.soft.network.raknet.RakNetPackets;

import java.nio.ByteBuffer;

/**
 * Created by jython234 on 5/8/2015.
 */
public class ConnectedPingPacket extends RakNetPacket{
    public long pingId;

    @Override
    protected void _decode(ByteBuffer bb) {
        bb.get(); //PID
        pingId = bb.getLong();
        bb.get(RakNetPackets.MAGIC); //MAGIC
    }

    @Override
    public int getLength() {
        return 25;
    }

}
