package com.harishkannarao.demo.feature_toggle;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.util.TestSocketUtils;

@SpringBootTest(
        classes = {FeatureToggleApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public abstract class AbstractBaseIntTest {

    private static final Logger log = LoggerFactory.getLogger(AbstractBaseIntTest.class);

    @DynamicPropertySource
    static void registerTestProperties(DynamicPropertyRegistry registry) {
        final int RANDOM_SERVER_PORT = TestSocketUtils.findAvailableTcpPort();
        registry.add("test.server.port", () -> String.valueOf(RANDOM_SERVER_PORT));
    }

    @Autowired
    @Value("${test.server.port}")
    private int testServerPort;

    @BeforeEach
    public void initRestAssured() {
        log.info("Initializing RestAssured before every test using Junit's @BeforeEach with @Autowired");
        final RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("http://localhost:%s/feature_toggle".formatted(testServerPort));
        requestSpecBuilder.log(LogDetail.ALL);
        final RequestSpecification requestSpecification = requestSpecBuilder.build();

        final ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.log(LogDetail.ALL);
        final ResponseSpecification responseSpecification = responseSpecBuilder.build();

        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }
}
