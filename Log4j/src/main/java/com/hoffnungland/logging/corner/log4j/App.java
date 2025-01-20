package com.hoffnungland.logging.corner.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * The App class serves as the entry point for the application.
 * It demonstrates basic logging functionality using Log4j.
 */
public class App 
{
	private static final Logger logger = LogManager.getLogger(App.class);
	
    /**
     * The main method is the entry point of the application.
     * It logs a "Hello World!" message at the INFO level.
     *
     * @param args Command line arguments
     */
    public static void main( String[] args )
    {
    	logger.traceEntry();
    	logger.info( "Hello World!" );
    	logger.traceExit();
    }
}
