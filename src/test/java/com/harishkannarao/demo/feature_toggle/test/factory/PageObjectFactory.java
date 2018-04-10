package com.harishkannarao.demo.feature_toggle.test.factory;

import com.harishkannarao.demo.feature_toggle.test.constants.TestConstants;
import com.harishkannarao.demo.feature_toggle.test.page_objects.HomePage;

public class PageObjectFactory {
    private final WebDriverFactory webDriverFactory;

    public PageObjectFactory(WebDriverFactory webDriverFactory) {

        this.webDriverFactory = webDriverFactory;
    }

    public HomePage createHomePage() {
        return new HomePage(TestConstants.APPLICATION_TEST_URL, webDriverFactory.newWebDriver());
    }
}
