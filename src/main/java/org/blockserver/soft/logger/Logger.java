package org.blockserver.soft.logger;

/**
 * Interface for all Logger Adapters.
 */
public interface Logger {

    /**
     * Log a DEBUG level message.
     * @param message The message
     */
    void debug(String message);
    /**
     * Log an INFO level message.
     * @param message The message
     */
    void info(String message);
    /**
     * Log a WARNING level message.
     * @param message The message
     */
    void warn(String message);
    /**
     * Log an ERROR level message.
     * @param message The message
     */
    void error(String message);
    /**
     * Log a SEVERE level message.
     * @param message The message
     */
    void severe(String message);
}
