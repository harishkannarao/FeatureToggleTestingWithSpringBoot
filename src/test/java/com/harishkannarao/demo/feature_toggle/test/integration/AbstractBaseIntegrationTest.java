package com.harishkannarao.demo.feature_toggle.test.integration;

import com.harishkannarao.demo.feature_toggle.FeatureToggleTestingDemoApplication;
import com.harishkannarao.demo.feature_toggle.test.configuration.IntegrationTestConfiguration;
import com.harishkannarao.demo.feature_toggle.test.factory.PageObjectFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.RestClientFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.WebDriverFactory;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = {
                FeatureToggleTestingDemoApplication.class,
                IntegrationTestConfiguration.class
        },
        webEnvironment = DEFINED_PORT
)
public abstract class AbstractBaseIntegrationTest {

    @Autowired
    protected WebDriverFactory webDriverFactory;
    @Autowired
    protected PageObjectFactory pageObjectFactory;
    @Autowired
    protected RestClientFactory restClientFactory;

    @After
    public void globalTearDown() {
        webDriverFactory.closeAllWebDrivers();
    }

}
