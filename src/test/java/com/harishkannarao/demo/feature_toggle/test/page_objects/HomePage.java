package com.harishkannarao.demo.feature_toggle.test.page_objects;

import com.harishkannarao.demo.feature_toggle.test.dto.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class HomePage extends AbstractBasePage {

    public HomePage(String baseUrl, WebDriver webDriver) {
        super(baseUrl, webDriver);
    }

    public void navigate() {
        super.navigateTo(baseUrl);
    }

    public Optional<String> getBannerMessage() {
        return super.getElementText("bannerMsg");
    }

    public List<Product> getProducts() {
        List<WebElement> products = super.getElementByClass("product");
        return products.stream().map(webElement -> {
            String name = webElement.findElement(By.className("product-name")).getText();
            String description = webElement.findElement(By.className("product-description")).getText();
            return new Product(name, description);
        }).collect(toList());
    }

}
