package com.harishkannarao.demo.feature_toggle.test.page_objects;

import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class HomePage extends AbstractBasePage {

    public HomePage(String baseUrl, WebDriver webDriver) {
        super(baseUrl, webDriver);
    }

    public void navigate() {
        super.navigateTo(baseUrl);
    }

    public Optional<String> getMessage() {
        return super.getElementText("msg");
    }

    public Optional<String> getBannerMessage() {
        return super.getElementText("bannerMsg");
    }
}
