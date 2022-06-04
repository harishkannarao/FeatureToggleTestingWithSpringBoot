package com.harishkannarao.demo.feature_toggle.test.integration;

import com.harishkannarao.demo.feature_toggle.test.factory.PageObjectFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.RestClientFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.WebDriverFactory;
import com.harishkannarao.demo.feature_toggle.test.runner.ShutdownExtension;
import com.harishkannarao.demo.feature_toggle.test.runner.SpringBootTestRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Properties;

@ExtendWith({ShutdownExtension.class})
public abstract class AbstractBaseIntegrationTest {

    private WebDriverFactory webDriverFactory;
    protected PageObjectFactory pageObjectFactory;
    protected RestClientFactory restClientFactory;

    protected Properties getOverriddenProperties() {
        return new Properties();
    }

    private Properties getFixedProperties() {
        Properties value = new Properties();
        value.put("spring.profiles.active", "int-test");
        return value;
    }

    private Properties getTestProperties() {
        Properties value = new Properties(getFixedProperties());
        value.putAll(getOverriddenProperties());
        return value;
    }

    @BeforeEach
    public void resetApplication() {
        if (!SpringBootTestRunner.isRunning()) {
            SpringBootTestRunner.start(getTestProperties());
        } else {
            if (!getTestProperties().equals(SpringBootTestRunner.getProperties())) {
                SpringBootTestRunner.restart(getTestProperties());
            }
        }
        webDriverFactory = new WebDriverFactory();
        pageObjectFactory = new PageObjectFactory(SpringBootTestRunner.getApplicationUrl(), webDriverFactory);
        restClientFactory = new RestClientFactory(SpringBootTestRunner.getApplicationUrl());
    }

    @AfterEach
    public void globalTearDown() {
        webDriverFactory.closeAllWebDrivers();
    }

}
