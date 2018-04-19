package com.harishkannarao.demo.feature_toggle.test.rest;

import com.harishkannarao.demo.feature_toggle.test.constants.TestConstants;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ProductsApiRestRequest {
    private final String testUrl;
    private final String path = "/api/products";

    public ProductsApiRestRequest(String baseUrl) {

        this.testUrl = baseUrl;
    }

    public ProductsApiRestResponse execute() {
        ValidatableResponse response = given()
                .get(TestConstants.APPLICATION_TEST_URL + path)
                .then();
        return new ProductsApiRestResponse(response);
    }
}
