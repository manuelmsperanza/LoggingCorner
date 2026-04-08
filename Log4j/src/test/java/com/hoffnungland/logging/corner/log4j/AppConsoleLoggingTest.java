package com.hoffnungland.logging.corner.log4j;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class AppConsoleLoggingTest {

	@Rule
	public final TemporaryFolder temporaryFolder = new TemporaryFolder();

	@After
	public void resetLogging() {
		Log4jTestSupport.clear();
	}

	@Test
	public void mainLogsHelloWorldToConsole() throws Exception {
		ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		PrintStream redirectedOut = new PrintStream(capturedOutput, true, StandardCharsets.UTF_8.name());

		try {
			System.setOut(redirectedOut);
			Log4jTestSupport.configure("stdout", temporaryFolder.getRoot().toPath(), "console-test");

			App.main(new String[0]);
		} finally {
			System.setOut(originalOut);
			redirectedOut.close();
		}

		String output = capturedOutput.toString(StandardCharsets.UTF_8.name());
		assertTrue("Expected the INFO log line in console output", output.contains("Hello World!"));
		assertTrue("Expected the logger metadata in console output", output.contains("INFO"));
	}
}
