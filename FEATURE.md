# Feature Summary

## Overview

`LoggingCorner` is a Maven multi-module workspace for experimenting with Java logging setup.
The current implementation is centered on the `Log4j` module, which demonstrates a minimal
Log4j 2 application and a reusable logging configuration.

## Current Feature Set

### 1. Multi-module Maven structure

- Root project packages the workspace as a parent `pom`.
- `Log4j` is the active child module.
- Shared Java and Maven settings are defined at the root level.

### 2. Basic Log4j 2 application

- Entry point: `Log4j/src/main/java/com/hoffnungland/logging/corner/log4j/App.java`
- The application initializes a Log4j logger through `LogManager`.
- Running the app emits:
  - `traceEntry()`
  - an `INFO` message with `Hello World!`
  - `traceExit()`

### 3. Central Log4j configuration

- Configuration file: `Log4j/src/main/resources/log4j2.xml`
- Supports two appenders:
  - console output through `stdout`
  - rolling file output under `logs/`
- Uses configurable properties for:
  - active appender profile
  - active log level
  - rolling file base name
- Reload monitoring is enabled with `monitorInterval="15"`.

### 4. Rolling file logging

- Log file path: `logs/Log4j.log`
- Archived log pattern: `logs/yyyy-MM/Log4j-MM-dd-yyyy-i.log`
- Rotation policies:
  - time-based rollover
  - size-based rollover at `10 MB`

### 5. Runtime defaults

- Default JVM run options are documented in
  `Log4j/src/main/filters/default.properties`
- The default configuration points the runtime to `log4j2.xml` and starts with a
  `TRACE`-friendly setup.

## Current Limitations

- The test suite only contains a placeholder assertion and does not verify logging behavior.
- The repository demonstrates one simple executable flow rather than a broader application use case.
- Dependencies for extra integrations are present, but the codebase does not yet show concrete examples for them.

## Suggested Next Features

1. Add tests that assert console and rolling-file logging behavior.
2. Add profile-specific configurations for local, CI, and production-style runs.
3. Add examples for SLF4J, JUL, and legacy Log4j bridge usage.
4. Document how to run the sample and inspect generated log files.
