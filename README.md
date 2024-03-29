# LoggingCorner

# Build settings
## Add prerequisites

	<prerequisites>
		<maven>3.1.0</maven>
	</prerequisites>

Update to java 1.8<br>
	
	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<java.source.version>1.8</java.source.version>
		<java.target.version>1.8</java.target.version>
	</properties>

## Configure the plugins
	
	<build>
		<pluginManagement><!-- lock down plugins versions to avoid using Maven 
				defaults (may be moved to parent pom) -->
			<plugins>
				<plugin>
					<artifactId>maven-clean-plugin</artifactId>
					<version>3.1.0</version>
				</plugin>
				<!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
				<plugin>
					<artifactId>maven-resources-plugin</artifactId>
					<version>3.1.0</version>
				</plugin>
				<plugin>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>3.8.0</version>
					<configuration>
						<encoding>UTF-8</encoding>
						<source>${java.source.version}</source>
						<target>${java.target.version}</target>
					</configuration>
				</plugin>
				<plugin>
					<artifactId>maven-surefire-plugin</artifactId>
					<version>3.0.0-M2</version>
				</plugin>
				<plugin>
					<artifactId>maven-jar-plugin</artifactId>
					<version>3.1.1</version>
				</plugin>
				<plugin>
					<artifactId>maven-install-plugin</artifactId>
					<version>3.0.0-M1</version>
				</plugin>
				<plugin>
					<artifactId>maven-deploy-plugin</artifactId>
					<version>3.0.0-M1</version>
				</plugin>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-enforcer-plugin</artifactId>
					<version>3.0.0-M2</version>
				</plugin>
			</plugins>
		</pluginManagement>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-enforcer-plugin</artifactId>
				<executions>
					<execution>
						<id>enforce-maven</id>
						<goals>
							<goal>enforce</goal>
						</goals>
						<configuration>
							<rules>
								<requireMavenVersion>
									<version>3.0.5</version>
								</requireMavenVersion>
								<requireJavaVersion>
									<version>1.8.0</version>
								</requireJavaVersion>
							</rules>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>

# add .gitignore to mandatory empty directory

	# Ignore everything in this directory
	*
	# Except this file
	!.gitignore

# Configure the Package Clean UP Automation with GitHub Action

The Action run during the release phase of package (or you can run it manually).
Leave only the latest package version into the repository.
Create the .github/workflows/cleanupPackages.yml file.
