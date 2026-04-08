package com.hoffnungland.logging.corner.log4j;

import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

final class Log4jTestSupport {

	private static final String ACTIVE_PROFILE_PROPERTY = "testActiveProfile";
	private static final String LOG_DIR_PROPERTY = "testLogDir";
	private static final String ROLLING_FILENAME_PROPERTY = "testRollingFilename";

	private Log4jTestSupport() {
	}

	static void configure(String activeProfile, Path logDir, String rollingFilename) {
		System.setProperty(ACTIVE_PROFILE_PROPERTY, activeProfile);
		System.setProperty(LOG_DIR_PROPERTY, logDir.toAbsolutePath().toString());
		System.setProperty(ROLLING_FILENAME_PROPERTY, rollingFilename);
		reconfigure();
	}

	static void clear() {
		System.clearProperty(ACTIVE_PROFILE_PROPERTY);
		System.clearProperty(LOG_DIR_PROPERTY);
		System.clearProperty(ROLLING_FILENAME_PROPERTY);
		reconfigure();
	}

	private static void reconfigure() {
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		context.reconfigure();
	}
}
