# Feature Toggle Testing With Spring Boot

This repository is to demonstrate feature toggle functional testing (developer's integration testing) with Spring Boot. Spring boot and dependency injection is used in this repository, still the code can be ported to projects using no frameworks or other frameworks.

## Github Actions Build status
[![Build Status](https://github.com/harishkannarao/FeatureToggleTestingWithSpringBoot/workflows/CI-master/badge.svg)](https://github.com/harishkannarao/FeatureToggleTestingWithSpringBoot/actions?query=workflow%3ACI-master)

## Required Softwares, Tools and Version
* Java JDK Version: 21
* Apache Maven Version: 3.9.9
* Gradle Version: 8
* Git Client: Any latest version
* Integrated Development Environment: Any version of IntelliJ Idea or Eclipse

## Approach to feature toggle integration test

#### Please refer to my blog post about feature toggle and importance of integration testing

[Feature Toggle Integration Testing with Spring Boot](https://blogs.harishkannarao.com/2018/04/feature-toggle-integration-testing-with.html)

## Running the build

Note: For maven users on Windows, please use **mvnw.cmd** instead of **./mvnw** in the following commands
Note: For gradle users on Windows, please use **gradlew.bat** instead of **./gradlew** in the following commands

###### For Maven users

    ./mvnw clean install

To generate html reports

    ./mvnw surefire-report:report-only surefire-report:failsafe-report-only

###### For Gradle users

    ./gradlew clean build

## Running the application using build tool

###### For Maven users
With feature toggled off (default behaviour)

    ./mvnw spring-boot:run

With feature toggled on

    ./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dfeature-flags.enable-conditional-api=true"

With feature toggle integration test configuration

    ./mvnw test-compile exec:java@run-local-ft -Dfeature-flags.enable-conditional-api=true

###### For Gradle users
With feature toggled off (default behaviour)

    ./gradlew bootRun

With feature toggled on

    ./gradlew runLocal -Dfeature-flags.enable-conditional-api=true

With feature toggle integration test configuration

     ./gradlew runLocalFt -Dfeature-flags.enable-conditional-api=true

###### Application url

    http://localhost:8080

## Run the sample application using java

Generate the jar file and start the application

###### For Maven users

    ./mvnw clean install -DskipUnitTests=true -DskipIntTests=true -DskipFtIntTests=true

With feature toggled off (default behaviour)

    java -jar target/feature-toggle-testing-with-spring-boot-0.0.1-SNAPSHOT.jar

With feature toggled on

    java -Dfeature-flags.enable-conditional-api=true -jar target/feature-toggle-testing-with-spring-boot-0.0.1-SNAPSHOT.jar

###### For Gradle users

    ./gradlew clean build -x test -x integrationTest -x ftIntegrationTest

With feature toggled off (default behaviour)

    java -jar build/libs/feature-toggle-testing-with-spring-boot-0.0.1-SNAPSHOT.jar 

With feature toggled on

    java -Dfeature-flags.enable-conditional-api=true -jar build/libs/feature-toggle-testing-with-spring-boot-0.0.1-SNAPSHOT.jar

###### Application url

    http://localhost:8080

## Feature toggling in production

For production environments, the feature flags will be enabled or disabled using environment variables. This will be a convenient way to toggle features using environment variable and restart the application with zero downtime and without the need to redeploy the application.

With spring boot `feature-flags.enable-conditional-api` property is represented by `FEATURE_FLAGS_ENABLE_CONDITIONAL_API` environment variable (i.e replace all '-' and '.' with '_')

Set the environment variable

    export FEATURE_FLAGS_ENABLE_CONDITIONAL_API=true

Start the application using java

    java -jar target/feature-toggle-testing-with-spring-boot-0.0.1-SNAPSHOT.jar

or

    java -jar build/libs/feature-toggle-testing-with-spring-boot-0.0.1-SNAPSHOT.jar

## List available dependencies from spring dependency management

    ./mvnw help:effective-pom

or

    ./gradlew dependencyManagement

## List currently added dependencies

    ./mvnw dependency:tree

or

    ./gradlew dependencies
