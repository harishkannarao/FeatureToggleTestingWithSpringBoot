import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("java")
    id("org.springframework.boot").apply(false)
}

// variables for gradle.properties
val javaVersion: String by project
val appVersion: String by project
val springBootVersion: String by project
val seleniumVersion: String by project
val assertjVersion: String by project
val restAssuredVersion: String by project
val bootstrapVersion: String by project
val junitVersion: String by project
val junitPlatformLauncherVersion: String by project
val commonsCollectionVersion: String by project

java.sourceCompatibility = JavaVersion.toVersion(javaVersion)
java.targetCompatibility = JavaVersion.toVersion(javaVersion)

allprojects {

    apply(plugin= "java")
    apply(plugin= "org.springframework.boot")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-devtools:${springBootVersion}")
        implementation("org.springframework.boot:spring-boot-starter:${springBootVersion}")
        implementation("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
        implementation("org.springframework.boot:spring-boot-starter-thymeleaf:${springBootVersion}")
        implementation("org.webjars:bootstrap:${bootstrapVersion}")

        testImplementation("org.springframework.boot:spring-boot-starter-test:${springBootVersion}")
        testImplementation("org.assertj:assertj-core:${assertjVersion}")
        testImplementation("org.seleniumhq.selenium:selenium-java:${seleniumVersion}")
        testImplementation("io.rest-assured:rest-assured:${restAssuredVersion}")
        testImplementation("io.rest-assured:json-path:${restAssuredVersion}")
        testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
        testImplementation("org.junit.platform:junit-platform-launcher:$junitPlatformLauncherVersion")
        testImplementation("org.apache.commons:commons-collections4:${commonsCollectionVersion}")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging.events = setOf(TestLogEvent.FAILED, TestLogEvent.SKIPPED, TestLogEvent.PASSED)
        val properties = System.getProperties().entries.associate { it.key.toString() to it.value }
        systemProperties(properties)
    }

    tasks.getByName<BootJar>("bootJar") {
        archiveClassifier.set("exec")
        archiveVersion.set(appVersion)
    }

    tasks.getByName<Jar>("jar") {
        archiveClassifier.set("")
        archiveVersion.set(appVersion)
    }

    task<JavaExec>("runLocal") {
        description = "Runs application locally"
        mainClass.set("com.harishkannarao.demo.feature_toggle.test.runner.SpringBootTestRunner")
        classpath = sourceSets["test"].runtimeClasspath
        args(listOf("--spring.profiles.active=int-test", "--server.port=8080"))
        val properties = System.getProperties().entries.associate { it.key.toString() to it.value }
        systemProperties(properties)
        dependsOn(tasks["compileJava"], tasks["compileTestJava"])
    }
}