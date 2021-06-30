package com.harishkannarao.demo.feature_toggle.test.factory;

import com.harishkannarao.demo.feature_toggle.test.page_objects.HomePage;

public class PageObjectFactory {

    private final String applicationUrl;
    private final WebDriverFactory webDriverFactory;

    public PageObjectFactory(String applicationUrl, WebDriverFactory webDriverFactory) {
        this.applicationUrl = applicationUrl;
        this.webDriverFactory = webDriverFactory;
    }

    public HomePage homePage() {
        return new HomePage(applicationUrl, webDriverFactory.newWebDriver());
    }
}
