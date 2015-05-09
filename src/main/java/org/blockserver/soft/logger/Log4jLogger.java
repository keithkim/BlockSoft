package org.blockserver.soft.logger;

import org.apache.logging.log4j.LogManager;

/**
 * A Logger implementation for Apache Log4j2.
 */
public class Log4jLogger implements Logger{
    private org.apache.logging.log4j.Logger logger;

    public Log4jLogger(String loggerName){
        logger = LogManager.getLogger(loggerName);
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void severe(String message) {
        logger.fatal(message);
    }
}
