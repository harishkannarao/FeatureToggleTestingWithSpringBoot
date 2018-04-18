package com.harishkannarao.demo.feature_toggle.test.page_objects;

import com.harishkannarao.demo.feature_toggle.test.dto.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage extends AbstractBasePage {

    public HomePage(String baseUrl, WebDriver webDriver) {
        super(baseUrl, webDriver);
    }

    public HomePage navigate() {
        super.navigateTo(baseUrl);
        return this;
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

    public HomePage expectBannerMessage(String message) {
        assertThat(getBannerMessage()).isEqualTo(Optional.of(message));
        return this;
    }

    public HomePage expectNoBannerMessage() {
        assertThat(getBannerMessage()).isEqualTo(Optional.empty());
        return this;
    }

    public HomePage expectTotalProductsDisplayedOnPageToBe(int count) {
        assertThat(getProducts()).hasSize(count);
        return this;
    }

    public HomePage expectProductIsDisplayedOnPage(Product product) {
        assertThat(getProducts())
                .usingRecursiveFieldByFieldElementComparator()
                .overridingErrorMessage("Product with name: <%s> and description: <%s> not found", product.getName(), product.getDescription())
                .contains(product);
        return this;
    }
}
