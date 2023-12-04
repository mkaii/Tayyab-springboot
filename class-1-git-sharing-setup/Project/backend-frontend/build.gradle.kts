plugins {
	java
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "be.kdg"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
	withSourcesJar()
}

tasks.register<Jar>("uberJar") {
	archiveClassifier = "uber"
	from(sourceSets.main.get().output)
	dependsOn(configurations.runtimeClasspath)
	from ({
		configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
	})
}

tasks.jar {
	manifest {
		attributes(
				"Main-Class" to "be.kdg.backendfrontend.BackendFrontendApplication",
				"Implementation-Title" to "Mobseeker",
				"Implementation-Version" to version
		)
	}
}


repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.junit.jupiter:junit-jupiter")
	implementation("com.google.code.gson:gson:2.10.1")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.webjars:bootstrap:5.3.2")
	implementation("org.webjars:webjars-locator-core:0.52")
	implementation("org.webjars.npm:bootstrap-icons:1.11.1")
	implementation("org.springframework.boot:spring-boot-devtools:3.1.5")
	implementation("org.springframework.boot:spring-boot-starter-validation:3.1.5")
	implementation("com.fazecast:jSerialComm:2.9.3")
//	JDBC
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	runtimeOnly ("com.h2database:h2")
	testImplementation ("org.springframework.boot:spring-boot-starter-test")
	implementation("org.postgresql:postgresql:42.6.0")
//	implementation ("com.github.grumlimited:geocalc:0.6") // geocalc
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}
