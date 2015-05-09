package org.blockserver.soft.network;

/**
 * Runtime Exception for RakNet related errors.
 */
public class RakNetException extends RuntimeException{

    public RakNetException(String message){
        super(message);
    }

    public RakNetException(Exception e){
        super(e);
    }
}
