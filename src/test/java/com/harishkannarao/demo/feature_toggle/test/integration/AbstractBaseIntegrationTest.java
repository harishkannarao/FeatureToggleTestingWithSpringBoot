package com.harishkannarao.demo.feature_toggle.test.integration;

import com.harishkannarao.demo.feature_toggle.test.factory.PageObjectFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.RestClientFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.WebDriverFactory;
import com.harishkannarao.demo.feature_toggle.test.runner.ShutdownExtension;
import com.harishkannarao.demo.feature_toggle.test.runner.SpringBootTestRunner;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Collections;
import java.util.List;

@ExtendWith({ShutdownExtension.class})
public abstract class AbstractBaseIntegrationTest {

    private WebDriverFactory webDriverFactory;
    protected PageObjectFactory pageObjectFactory;
    protected RestClientFactory restClientFactory;

    protected List<String> getTestProperties() {
        return Collections.emptyList();
    }

    @BeforeEach
    public void resetApplication() {
        if (!SpringBootTestRunner.getSingletonInstance().isRunning()) {
            SpringBootTestRunner.getSingletonInstance().start(getTestProperties());
        } else {
            if (!CollectionUtils.isEqualCollection(getTestProperties(), SpringBootTestRunner.getSingletonInstance().getProperties())) {
                SpringBootTestRunner.getSingletonInstance().restart(getTestProperties());
            }
        }
        webDriverFactory = SpringBootTestRunner.getSingletonInstance().getBean(WebDriverFactory.class);
        pageObjectFactory = SpringBootTestRunner.getSingletonInstance().getBean(PageObjectFactory.class);
        restClientFactory = SpringBootTestRunner.getSingletonInstance().getBean(RestClientFactory.class);
    }

    @AfterEach
    public void globalTearDown() {
        webDriverFactory.closeAllWebDrivers();
    }

}
