rootProject.name = "feature-toggle-testing-with-spring-boot"

pluginManagement {
    // variables for gradle.properties
    val springBootVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.springframework.boot" -> useVersion(springBootVersion)
            }
        }
    }
}