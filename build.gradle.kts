plugins {
	java
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.harishkannarao.demo"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.rest-assured:rest-assured")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
	testLogging {
		events("passed", "failed", "skipped")
	}
}

tasks.named<Test>("test") {
	filter {
		excludeTestsMatching("com.harishkannarao.demo.feature_toggle.integration.*")
		excludeTestsMatching("com.harishkannarao.demo.feature_toggle.ft_integration.*")
	}
}

val integrationTest = task<Test>("integrationTest") {
	description = "Runs integration tests."
	group = "verification"
	shouldRunAfter("test")
	filter {
		includeTestsMatching("com.harishkannarao.demo.feature_toggle.integration.*")
	}
}

val ftIntegrationTest = task<Test>("ftIntegrationTest") {
	description = "Runs feature toggle integration tests."
	group = "verification"
	shouldRunAfter("integrationTest")
	filter {
		includeTestsMatching("com.harishkannarao.demo.feature_toggle.ft_integration.*")
	}
}

tasks.check { dependsOn(integrationTest) }
tasks.check { dependsOn(ftIntegrationTest) }

task<JavaExec>("runLocal") {
	description = "Runs application locally with integration tests configuration"
	mainClass.set("com.harishkannarao.demo.feature_toggle.FeatureToggleApplicationLocalRunner")
	classpath = sourceSets["test"].runtimeClasspath
	args(listOf("--spring.profiles.active=int-test", "--server.port=8080"))
	val properties = System.getProperties().entries.associate { it.key.toString() to it.value }
	systemProperties(properties)
	dependsOn(tasks["compileJava"], tasks["compileTestJava"])
}

task<JavaExec>("runLocalFt") {
	description = "Runs application locally with feature toggle configuration"
	mainClass.set("com.harishkannarao.demo.feature_toggle.FeatureToggleApplicationLocalRunner")
	classpath = sourceSets["test"].runtimeClasspath
	args(listOf("--spring.profiles.active=ft-int-test", "--server.port=8080"))
	val properties = System.getProperties().entries.associate { it.key.toString() to it.value }
	systemProperties(properties)
	dependsOn(tasks["compileJava"], tasks["compileTestJava"])
}




