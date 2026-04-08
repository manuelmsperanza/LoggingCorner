package com.hoffnungland.logging.corner.log4j;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Test class for verifying rolling file logging from the App class.
 */
class AppRollingFileLoggingTest {

	@TempDir
	Path temporaryFolder;

	/**
	 * Resets Log4j configuration after each test.
	 */
	@AfterEach
	void resetLogging() {
		Log4jTestSupport.clear();
	}

	/**
	 * Tests that the App.main method logs "Hello World!" to a rolling log file.
	 *
	 * @throws Exception if an error occurs during test execution
	 */
	@Test
	void mainLogsHelloWorldToRollingFile() throws Exception {
		Path logDirectory = temporaryFolder;
		Path logFile = logDirectory.resolve("file-test.log");

		Log4jTestSupport.configure("rollingFile", logDirectory, "file-test");

		App.main(new String[0]);

		assertTrue(Files.exists(logFile), "Expected the rolling log file to be created");

		String output = Files.readString(logFile, StandardCharsets.UTF_8);
		assertTrue(output.contains("Hello World!"), "Expected the INFO log line in the rolling file");
		assertTrue(output.contains("INFO"), "Expected the logger metadata in the rolling file");
	}
}
