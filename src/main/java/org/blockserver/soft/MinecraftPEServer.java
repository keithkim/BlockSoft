package org.blockserver.soft;

import org.blockserver.soft.logger.Logger;
import org.blockserver.soft.network.RakNetInterface;

import java.net.InetSocketAddress;

/**
 * An implementation of a Minecraft: Pocket Edition server.
 */
public class MinecraftPEServer implements Runnable{

    private BlockSoft soft;
    private RakNetInterface rakNetInterface;

    public MinecraftPEServer(InetSocketAddress bindAddress, BlockSoft soft){
        rakNetInterface = RakNetInterface.getInterface(bindAddress, this);
        this.soft = soft;
    }

    @Override
    public void run() {
        rakNetInterface.startInterface();
    }

    public Logger getLogger(){
        return soft.getLogger();
    }
}
