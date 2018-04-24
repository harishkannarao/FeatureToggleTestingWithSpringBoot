# Feature Toggle Testing With Spring Boot

This repository is to demonstrate feature toggle functional testing (developer's integration testing) with Spring Boot. Spring boot and dependency injection is used in this repository, still the code can be ported to projects using no frameworks or other frameworks.

## Travis CI Build status
[![Build Status](https://travis-ci.org/harishkannarao/FeatureToggleTestingWithSpringBoot.svg?branch=master)](https://travis-ci.org/harishkannarao/FeatureToggleTestingWithSpringBoot)

## Required Softwares, Tools and Version
* Java JDK Version: 9
* Apache Maven Version: 3.3.9
* Gradle Version: 4.6
* Chrome (Windows & Mac OS) Browser / Chromium (Linux OS) Browser: 66
* chromedriver: 2.37 [chromedriver installation steps](https://blogs.harishkannarao.com/2018/01/installing-chromedriver-for-selenium.html)
* Git Client: Any latest version
* Integrated Development Environment: Any version of IntelliJ Idea or Eclipse

## Approach to feature toggle integration test

#### Please refer to my blog post about feature toggle and importance of integration testing

[Feature Toggle Integration Testing with Spring Boot](https://blogs.harishkannarao.com/2018/04/feature-toggle-integration-testing-with.html)

#### com.harishkannarao.demo.feature_toggle.property.PropertyReader
This class defines an interface for the application on the properties that can be read from properties file or yaml file or an environment variable

#### com.harishkannarao.demo.feature_toggle.property.DefaultPropertyReader
This class is the actual implementation which reads value from properties file or yaml file or an environment variable using Spring annotation
```
@Value("${application-config.display-hidden-products}") boolean displayHiddenProducts
```

#### com.harishkannarao.demo.feature_toggle.test.property.TestPropertyReader
This class is a utility class, which can be controlled by the integration test to enable or disable the feature toggle. This class implements `PropertyReader` interface and wraps `DefaultPropertyReader` object and hence can be injected into the application as a replacement for `DefaultPropertyReader`.

#### Replacing DefaultPropertyReader with TestPropertyReader
The following bean definition in `com.harishkannarao.demo.feature_toggle.test.configuration.IntegrationTestConfiguration` allows us to inject `TestPropertyReader` in places for `DefaultPropertyReader`
```
    @Bean
    @Primary
    public PropertyReader createTestPropertyReader(DefaultPropertyReader defaultPropertyReader) {
        return new TestPropertyReader(defaultPropertyReader);
    }
```

#### Sample integration tests
`com.harishkannarao.demo.feature_toggle.test.integration.HomePageIntegrationTest` tests the behaviour of a web page with feature toggle enabled and disabled.

`com.harishkannarao.demo.feature_toggle.test.integration.ProductsApiIntegrationTest` tests the behaviour of an api with feature toggle enabled and disabled.

#### Benefits of this approach
* Tests control the feature toggle without restarting the server or application
* Tests the application's behaviour with multiple layers within the application code (controllers and service class)
* Tests the application's default behaviour based on the configuration file


## Running the build
Note: For gradle users on Windows, please use **gradlew.bat** instead of **./gradlew** in the following commands

###### For Maven users

    mvn clean install
    
###### For Gradle users

    ./gradlew clean build
    
## Running the application using build tool

###### For Maven users
With feature toggled off (default behaviour)

    mvn spring-boot:run
    
With feature toggled on

    mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dapplication-config.display-hidden-products=true"
    
###### For Gradle users
With feature toggled off (default behaviour)

    ./gradlew bootRun
    
With feature toggled on
    
    ./gradlew bootRun -Dapplication-config.display-hidden-products=true
    
###### Application url

    http://localhost:8080
    
## Run the sample application using java

Generate the jar file and start the application

###### For Maven users

    mvn clean install -DskipTests=true
    
With feature toggled off (default behaviour)

    java -jar target/feature-toggle-testing-with-spring-boot-1.0-SNAPSHOT-exec.jar
    
With feature toggled on

    java -Dapplication-config.display-hidden-products=true -jar target/feature-toggle-testing-with-spring-boot-1.0-SNAPSHOT-exec.jar
    
###### For Gradle users
    
    ./gradlew clean assemble
    
With feature toggled off (default behaviour)

    java -jar build/libs/feature-toggle-testing-with-spring-boot-1.0-SNAPSHOT-exec.jar 
    
With feature toggled on

    java -Dapplication-config.display-hidden-products=true -jar build/libs/feature-toggle-testing-with-spring-boot-1.0-SNAPSHOT-exec.jar
    
###### Application url

    http://localhost:8080
    
## Feature toggling in production

Most of cloud providers like heroku or cloud foundry provide mechanism to set environment variables on application scope through configuration file. This will be a convenient way to toggle features using environment variable and restart the application with zero downtime and without the need to redeploy the application.

With spring boot `application-config.display-hidden-products` property is represented by `APPLICATION_CONFIG_DISPLAY_HIDDEN_PRODUCTS` environment variable (i.e replace all '-' and '.' with '_')

Set the environment variable

    export APPLICATION_CONFIG_DISPLAY_HIDDEN_PRODUCTS=true
    
Start the application using java

    java -jar target/feature-toggle-testing-with-spring-boot-1.0-SNAPSHOT-exec.jar
    
or

    java -jar build/libs/feature-toggle-testing-with-spring-boot-1.0-SNAPSHOT-exec.jar   
