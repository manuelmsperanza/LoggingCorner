package me.hoffnungland.logging.corner.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
    	logger.traceEntry();
    	logger.info( "Hello World!" );
    	logger.traceExit();
    }
}
