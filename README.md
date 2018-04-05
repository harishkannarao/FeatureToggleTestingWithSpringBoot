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

    mvn spring-boot:run
    
###### For Gradle users

    ./gradlew bootRun
    
###### Application url

    http://localhost:8080
    
## Run the sample application using java

Generate the jar file and start the application

###### For Maven users

    mvn clean install -DskipTests=true
    java -jar target/feature-toggle-testing-with-spring-boot-1.0-SNAPSHOT-exec.jar
    
###### For Gradle users
    
    ./gradlew clean assemble
    java -jar build/libs/feature-toggle-testing-with-spring-boot-1.0-SNAPSHOT-exec.jar 
    
###### Application url

    http://localhost:8080
