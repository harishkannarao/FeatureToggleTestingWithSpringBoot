package com.harishkannarao.demo.feature_toggle.test.integration;

import com.harishkannarao.demo.feature_toggle.FeatureToggleTestingDemoApplication;
import com.harishkannarao.demo.feature_toggle.test.configuration.IntegrationTestConfiguration;
import com.harishkannarao.demo.feature_toggle.test.factory.PageObjectFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.RestClientFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.WebDriverFactory;
import com.harishkannarao.demo.feature_toggle.test.property.TestPropertyReader;
import org.junit.After;
import org.junit.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public abstract class AbstractBaseIntegrationTest {

    private static final String[] defaultProperties = new String[]{};
    private static boolean runningDefaultApplication = false;
    private static ConfigurableApplicationContext application;
    private static WebDriverFactory webDriverFactory;
    static PageObjectFactory pageObjectFactory;
    static RestClientFactory restClientFactory;
    static TestPropertyReader testPropertyReader;

    protected void restartApplicationWithProperties(String... args) {
        runningDefaultApplication = false;
        runApplicationWithProperties(args);
    }

    @Before
    public void restartApplicationWithDefaultProperties() {
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
        testPropertyReader = application.getBean(TestPropertyReader.class);
    }

    @After
    public void globalTearDown() {
        webDriverFactory.closeAllWebDrivers();
    }

}
