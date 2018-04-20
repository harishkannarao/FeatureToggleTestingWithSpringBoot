package com.harishkannarao.demo.feature_toggle.test.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public abstract class AbstractBasePage<R extends AbstractBasePage> {
    protected final String baseUrl;
    protected final WebDriver webDriver;

    protected AbstractBasePage(String baseUrl, WebDriver webDriver) {
        this.baseUrl = baseUrl;
        this.webDriver = webDriver;
    }

    protected R navigateTo(String url) {
        webDriver.navigate().to(url);
        return (R) this;
    }

    protected Optional<String> getElementText(String id) {
        return webDriver.findElements(By.id(id)).stream().findFirst()
                .map(WebElement::getText);
    }

    protected List<WebElement> getElementByClass(String clazz) {
        return webDriver.findElements(By.className(clazz));
    }
}
