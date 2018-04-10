package com.harishkannarao.demo.feature_toggle.test.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Optional;

public abstract class AbstractBasePage {
    protected final String baseUrl;
    protected final WebDriver webDriver;

    protected AbstractBasePage(String baseUrl, WebDriver webDriver) {
        this.baseUrl = baseUrl;
        this.webDriver = webDriver;
    }

    protected void navigateTo(String url) {
        webDriver.navigate().to(url);
    }

    protected Optional<String> getElementText(String id) {
        return webDriver.findElements(By.id(id)).stream().findFirst()
                .map(WebElement::getText);
    }
}
