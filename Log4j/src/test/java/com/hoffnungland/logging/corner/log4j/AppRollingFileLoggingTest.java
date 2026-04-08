package com.hoffnungland.logging.corner.log4j;

import static org.junit.Assert.assertTrue;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class AppRollingFileLoggingTest {

	@Rule
	public final TemporaryFolder temporaryFolder = new TemporaryFolder();

	@After
	public void resetLogging() {
		Log4jTestSupport.clear();
	}

	@Test
	public void mainLogsHelloWorldToRollingFile() throws Exception {
		Path logDirectory = temporaryFolder.getRoot().toPath();
		Path logFile = logDirectory.resolve("file-test.log");

		Log4jTestSupport.configure("rollingFile", logDirectory, "file-test");

		App.main(new String[0]);

		assertTrue("Expected the rolling log file to be created", Files.exists(logFile));

		String output = Files.readString(logFile, StandardCharsets.UTF_8);
		assertTrue("Expected the INFO log line in the rolling file", output.contains("Hello World!"));
		assertTrue("Expected the logger metadata in the rolling file", output.contains("INFO"));
	}
}
