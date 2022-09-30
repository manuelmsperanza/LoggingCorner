# Create a new project

	mvn archetype:generate -Dfilter="org.apache.maven.archetypes:maven-archetype-quickstart" -DgroupId="com.hoffnungland" -DartifactId=Log4j -Dpackage="com.hoffnungland.logging.corner.log4j" -Dversion="1.0.1-SNAPSHOT"

# Build settings

# Relationship
## Add the dependencies
### Instruction to encrypt the password on maven settings.xml
[Encryption guide](http://maven.apache.org/guides/mini/guide-encryption.html)<br>

### Add log4j


		<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.apache.logging.log4j</groupId>
				<artifactId>log4j-bom</artifactId>
				<version>2.11.1</version>
				<scope>import</scope>
				<type>pom</type>
			</dependency>
		</dependencies>
	</dependencyManagement>
	<dependencies>
		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-api</artifactId>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
		<dependency>
		    <groupId>org.slf4j</groupId>
		    <artifactId>slf4j-api</artifactId>
		    <version>1.7.25</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/xalan/xalan -->
		<dependency>
		    <groupId>xalan</groupId>
		    <artifactId>xalan</artifactId>
		    <version>2.7.2</version>
		</dependency>
	</dependencies>

# add .gitignore to mandatory empty directory

	# Ignore everything in this directory
	*
	# Except this file
	!.gitignore
