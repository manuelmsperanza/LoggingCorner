package com.hoffnungland.logging.corner.log4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class Log4jTestSupportTest {

	private static final String ACTIVE_PROFILE_PROPERTY = "testActiveProfile";
	private static final String LOG_DIR_PROPERTY = "testLogDir";
	private static final String ROLLING_FILENAME_PROPERTY = "testRollingFilename";

	@AfterEach
	void resetLogging() {
		Log4jTestSupport.clear();
	}

	@Test
	void configureSetsExpectedSystemProperties(@TempDir Path temporaryFolder) {
		Log4jTestSupport.configure("rollingFile", temporaryFolder, "test-run");

		assertEquals("rollingFile", System.getProperty(ACTIVE_PROFILE_PROPERTY));
		assertEquals(temporaryFolder.toAbsolutePath().toString(), System.getProperty(LOG_DIR_PROPERTY));
		assertEquals("test-run", System.getProperty(ROLLING_FILENAME_PROPERTY));
	}

	@Test
	void clearRemovesConfiguredSystemProperties(@TempDir Path temporaryFolder) {
		Log4jTestSupport.configure("stdout", temporaryFolder, "to-clear");

		Log4jTestSupport.clear();

		assertNull(System.getProperty(ACTIVE_PROFILE_PROPERTY));
		assertNull(System.getProperty(LOG_DIR_PROPERTY));
		assertNull(System.getProperty(ROLLING_FILENAME_PROPERTY));
	}
}
