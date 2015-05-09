package org.blockserver.soft.network.raknet;

import java.util.Random;

/**
 * Collection of RakNet Packet constants
 */
public class RakNetPackets {

    /*
    public final static byte[] MAGIC = new byte[]{
            0x00, (byte) 0xff, (byte) 0xff, 0x00,
            (byte) 0xfe, (byte) 0xfe, (byte) 0xfe, (byte) 0xfe,
            (byte) 0xfd, (byte) 0xfd, (byte) 0xfd, (byte) 0xfd,
            0x12, 0x34, 0x56, 0x78};
    */
    public static byte[] MAGIC = new byte[16];

    public final static long SERVER_ID = new Random().nextLong();

    public final static byte ID_CONNECTED_PING_OPEN_CONNECTIONS = 0x01;
    public final static byte ID_UNCONNECTED_PING_OPEN_CONNECTIONS = 0x1c;
}
