package com.harishkannarao.demo.feature_toggle.configuration;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
@ConditionalOnProperty(name = "test.server.port")
public class TestRestTemplateConfiguration {

    private static final Logger log = LoggerFactory.getLogger(TestRestTemplateConfiguration.class);

    @Bean
    public InitializingBean initRestAssured(@Value("${test.server.port}") int testServerPort) {
        return () -> {
            log.info("Initializing RestAssured only once on startup using @TestConfiguration and @Import annotations");
            final RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
            requestSpecBuilder.setBaseUri("http://localhost:%s/feature_toggle".formatted(testServerPort));
            requestSpecBuilder.log(LogDetail.ALL);
            final RequestSpecification requestSpecification = requestSpecBuilder.build();

            final ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
            responseSpecBuilder.log(LogDetail.ALL);
            final ResponseSpecification responseSpecification = responseSpecBuilder.build();

            RestAssured.requestSpecification = requestSpecification;
            RestAssured.responseSpecification = responseSpecification;
        };
    }
}
