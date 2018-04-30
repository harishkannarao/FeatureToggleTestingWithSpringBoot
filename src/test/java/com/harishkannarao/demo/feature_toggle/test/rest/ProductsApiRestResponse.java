package com.harishkannarao.demo.feature_toggle.test.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.harishkannarao.demo.feature_toggle.test.dto.Product;
import io.restassured.response.ValidatableResponse;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsApiRestResponse extends AbstractBaseRestResponse<ProductsApiRestResponse> {

    public ProductsApiRestResponse(ValidatableResponse response) {
        super(response);
    }

    public ProductsApiRestResponse expectTotalProductsToBe(int count) {
        assertThat(getProducts()).hasSize(count);
        return this;
    }

    public List<Product> getProducts() {
        List<Product> result = new ArrayList<>();
        JsonNode entity = response.extract().jsonPath().getObject("", JsonNode.class);
        if (entity instanceof ArrayNode) {
            ArrayNode array = (ArrayNode) entity;
            for (JsonNode product: array) {
                String name = product.get("name").asText();
                String description = product.get("description").asText();
                result.add(new Product(name, description));
            }
        }
        return result;
    }

    public ProductsApiRestResponse expectProduct(Product product) {
        assertThat(getProducts())
                .usingRecursiveFieldByFieldElementComparator()
                .overridingErrorMessage("Product with name: <%s> and description: <%s> not found", product.getName(), product.getDescription())
                .contains(product);
        return this;
    }
}
