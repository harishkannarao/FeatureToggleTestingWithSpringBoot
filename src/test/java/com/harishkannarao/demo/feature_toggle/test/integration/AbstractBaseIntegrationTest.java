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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith({ShutdownExtension.class})
public abstract class AbstractBaseIntegrationTest {

    private WebDriverFactory webDriverFactory;
    protected PageObjectFactory pageObjectFactory;
    protected RestClientFactory restClientFactory;

    protected List<String> getOverriddenProperties() {
        return Collections.emptyList();
    }

    private List<String> getFixedProperties() {
        return List.of("--spring.profiles.active=int-test");
    }

    private List<String> getTestProperties() {
        List<String> result = new ArrayList<>();
        result.addAll(getFixedProperties());
        result.addAll(getOverriddenProperties());
        return result;
    }

    @BeforeEach
    public void resetApplication() {
        if (!SpringBootTestRunner.isRunning()) {
            SpringBootTestRunner.start(getTestProperties());
        } else {
            if (!CollectionUtils.isEqualCollection(getTestProperties(), SpringBootTestRunner.getProperties())) {
                SpringBootTestRunner.restart(getTestProperties());
            }
        }
        webDriverFactory = SpringBootTestRunner.getBean(WebDriverFactory.class);
        pageObjectFactory = SpringBootTestRunner.getBean(PageObjectFactory.class);
        restClientFactory = SpringBootTestRunner.getBean(RestClientFactory.class);
    }

    @AfterEach
    public void globalTearDown() {
        webDriverFactory.closeAllWebDrivers();
    }

}
