package com.hoffnungland.logging.corner.log4j;

import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

/**
 * Utility class for configuring Log4j in tests.
 * Provides methods to configure and clear Log4j test settings.
 */
final class Log4jTestSupport {

	private static final String ACTIVE_PROFILE_PROPERTY = "testActiveProfile";
	private static final String LOG_DIR_PROPERTY = "testLogDir";
	private static final String ROLLING_FILENAME_PROPERTY = "testRollingFilename";

	/**
	 * Private constructor to prevent instantiation.
	 */
	private Log4jTestSupport() {
	}

	/**
	 * Configures Log4j with the specified test settings.
	 *
	 * @param activeProfile the active profile name
	 * @param logDir the directory for log files
	 * @param rollingFilename the filename for rolling log files
	 */
	static void configure(String activeProfile, Path logDir, String rollingFilename) {
		System.setProperty(ACTIVE_PROFILE_PROPERTY, activeProfile);
		System.setProperty(LOG_DIR_PROPERTY, logDir.toAbsolutePath().toString());
		System.setProperty(ROLLING_FILENAME_PROPERTY, rollingFilename);
		reconfigure();
	}

	/**
	 * Clears Log4j test configuration settings.
	 */
	static void clear() {
		System.clearProperty(ACTIVE_PROFILE_PROPERTY);
		System.clearProperty(LOG_DIR_PROPERTY);
		System.clearProperty(ROLLING_FILENAME_PROPERTY);
		reconfigure();
	}

	/**
	 * Reconfigures the LoggerContext to pick up configuration changes.
	 */
	private static void reconfigure() {
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		context.reconfigure();
	}
}
