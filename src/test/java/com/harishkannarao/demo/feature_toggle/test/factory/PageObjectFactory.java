package com.harishkannarao.demo.feature_toggle.test.factory;

import com.harishkannarao.demo.feature_toggle.test.constants.TestConstants;
import com.harishkannarao.demo.feature_toggle.test.page_objects.HomePage;
import org.openqa.selenium.WebDriver;

public class PageObjectFactory {

    public HomePage createHomePage(WebDriver webDriver) {
        return new HomePage(TestConstants.APPLICATION_TEST_URL, webDriver);
    }
}
