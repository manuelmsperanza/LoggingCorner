package com.hoffnungland.logging.corner.log4j;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Test class for verifying console logging output from the App class.
 */
class AppConsoleLoggingTest {

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
	 * Tests that the App.main method logs "Hello World!" to console output.
	 *
	 * @throws Exception if an error occurs during test execution
	 */
	@Test
	void mainLogsHelloWorldToConsole() throws Exception {
		ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		PrintStream redirectedOut = new PrintStream(capturedOutput, true, StandardCharsets.UTF_8.name());

		try {
			System.setOut(redirectedOut);
			Log4jTestSupport.configure("stdout", temporaryFolder, "console-test");

			App.main(new String[0]);
		} finally {
			System.setOut(originalOut);
			redirectedOut.close();
		}

		String output = capturedOutput.toString(StandardCharsets.UTF_8.name());
		assertTrue(output.contains("Hello World!"), "Expected the INFO log line in console output");
		assertTrue(output.contains("INFO"), "Expected the logger metadata in console output");
	}
}
