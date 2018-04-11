# Feature Toggle Testing With Spring Boot

This repository is to demonstrate feature toggle functional testing (developer's integration testing) with Spring Boot. Spring boot and dependency injection is used in this repository, still the code can be ported to projects using no frameworks or other frameworks.

## Travis CI Build status
[![Build Status](https://travis-ci.org/harishkannarao/FeatureToggleTestingWithSpringBoot.svg?branch=master)](https://travis-ci.org/harishkannarao/FeatureToggleTestingWithSpringBoot)

## Required Softwares, Tools and Version
* Java JDK Version: 9
* Apache Maven Version: 3.3.9
* Gradle Version: 4.6
* Chrome (Windows & Mac OS) Browser / Chromium (Linux OS) Browser: 62
* chromedriver: 2.32 [chromedriver installation steps](https://blogs.harishkannarao.com/2018/01/installing-chromedriver-for-selenium.html)
* Git Client: Any latest version
* Integrated Development Environment: Any version of IntelliJ Idea or Eclipse

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
