package com.harishkannarao.demo.feature_toggle.test.integration;

import com.harishkannarao.demo.feature_toggle.FeatureToggleTestingDemoApplication;
import com.harishkannarao.demo.feature_toggle.test.configuration.IntegrationTestConfiguration;
import com.harishkannarao.demo.feature_toggle.test.factory.PageObjectFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.RestClientFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public abstract class AbstractBaseIntegrationTest {

    private static final String[] defaultProperties = new String[]{};
    private static boolean runningDefaultApplication = false;
    private static ConfigurableApplicationContext application;
    private static WebDriverFactory webDriverFactory;
    static PageObjectFactory pageObjectFactory;
    static RestClientFactory restClientFactory;

    void displayHiddenProducts() {
        restartApplicationWithProperties("--application-config.display-hidden-products=true");
    }

    void doNotDisplayHiddenProducts() {
        restartApplicationWithProperties("--application-config.display-hidden-products=false");
    }

    void enableConditionalApi() {
        restartApplicationWithProperties("--conditional-api.enabled=true");
    }

    void disableConditionalApi() {
        restartApplicationWithProperties("--conditional-api.enabled=false");
    }

    void enableDifferentMessageService() {
        restartApplicationWithProperties("--conditional-service.name=different");
    }

    void enableDefaultMessageService() {
        restartApplicationWithProperties("--conditional-service.name=default");
    }

    @BeforeEach
    public void resetApplication() {
        restartApplicationWithDefaultProperties();
    }

    @AfterEach
    public void globalTearDown() {
        webDriverFactory.closeAllWebDrivers();
    }

    private static void restartApplicationWithProperties(String... args) {
        runningDefaultApplication = false;
        runApplicationWithProperties(args);
    }

    @SuppressWarnings("WeakerAccess")
    @BeforeAll
    public static void restartApplicationWithDefaultProperties() {
        if (!runningDefaultApplication) {
            runningDefaultApplication = true;
            runApplicationWithProperties(defaultProperties);
        }
    }

    private static void runApplicationWithProperties(String... args) {
        if (application != null && application.isRunning()) {
            SpringApplication.exit(application);
        }
        application = SpringApplication.run(
                new Class[]{
                        FeatureToggleTestingDemoApplication.class,
                        IntegrationTestConfiguration.class
                },
                args
        );
        webDriverFactory = application.getBean(WebDriverFactory.class);
        pageObjectFactory = application.getBean(PageObjectFactory.class);
        restClientFactory = application.getBean(RestClientFactory.class);
    }

}
