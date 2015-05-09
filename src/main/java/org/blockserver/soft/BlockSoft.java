package org.blockserver.soft;

import org.blockserver.soft.logger.Log4jLogger;
import org.blockserver.soft.logger.Logger;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Main running class for BlockSoft.
 */
public class BlockSoft implements Runnable{
    public final static String VERSION = "v1.0-ALPHA";
    public final static String MC_IMPL = "MCPE 0.11.0 build 6, protocol 25";

    private static Logger LOGGER;

    public static void main(String[] args){
        BlockSoft soft = new BlockSoft();
        soft.run();
    }

    @Override
    public void run() {
        LOGGER = new Log4jLogger("BlockSoft");
        LOGGER.info("BlockSoft version "+VERSION+", implementing "+MC_IMPL);
        try {
            MinecraftPEServer server = new MinecraftPEServer(new InetSocketAddress(InetAddress.getLoopbackAddress(), 19132), this);
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger(){
        return LOGGER;
    }
}
