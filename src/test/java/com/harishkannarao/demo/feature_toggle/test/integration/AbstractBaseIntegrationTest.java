package com.harishkannarao.demo.feature_toggle.test.integration;

import com.harishkannarao.demo.feature_toggle.FeatureToggleTestingDemoApplication;
import com.harishkannarao.demo.feature_toggle.test.configuration.IntegrationTestConfiguration;
import com.harishkannarao.demo.feature_toggle.test.factory.PageObjectFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.RestClientFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
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

    @Before
    public void resetApplication() {
        restartApplicationWithDefaultProperties();
    }

    @After
    public void globalTearDown() {
        webDriverFactory.closeAllWebDrivers();
    }

    private static void restartApplicationWithProperties(String... args) {
        runningDefaultApplication = false;
        runApplicationWithProperties(args);
    }

    @SuppressWarnings("WeakerAccess")
    @BeforeClass
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
