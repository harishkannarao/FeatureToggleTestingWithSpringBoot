package com.harishkannarao.demo.feature_toggle.test.rest;

import com.harishkannarao.demo.feature_toggle.test.dto.Product;
import io.restassured.response.ValidatableResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsApiRestResponse {
    private final ValidatableResponse response;

    public ProductsApiRestResponse(ValidatableResponse response) {

        this.response = response;
    }

    public ProductsApiRestResponse expectSuccessStatusCode() {
        response.statusCode(200);
        return this;
    }

    public ProductsApiRestResponse expectTotalProductsToBe(int count) {
        assertThat(getProducts()).hasSize(count);
        return this;
    }

    public List<Product> getProducts() {
        return response.extract().jsonPath().getList("", Product.class);
    }

    public ProductsApiRestResponse expectProduct(Product product) {
        assertThat(getProducts())
                .usingRecursiveFieldByFieldElementComparator()
                .overridingErrorMessage("Product with name: <%s> and description: <%s> not found", product.getName(), product.getDescription())
                .contains(product);
        return this;
    }
}
