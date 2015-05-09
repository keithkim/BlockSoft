package org.blockserver.soft.network.raknet;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.ByteBuffer;

/**
 * Base class for RakNet packets.
 */
public abstract class RakNetPacket {

    public byte[] encode(){
        ByteBuffer bb = ByteBuffer.allocate(getLength());
        _encode(bb);
        return bb.array();
    }

    public void decode(byte[] buffer){
        ByteBuffer bb = ByteBuffer.wrap(buffer);
        _decode(bb);
    }

    protected void _encode(ByteBuffer bb){
        throw new NotImplementedException();
    }

    protected void _decode(ByteBuffer bb){
        throw new NotImplementedException();
    }

    public abstract int getLength();
}
