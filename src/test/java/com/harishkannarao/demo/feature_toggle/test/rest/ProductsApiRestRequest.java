package com.harishkannarao.demo.feature_toggle.test.rest;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ProductsApiRestRequest extends AbstractBaseRestRequest<ProductsApiRestRequest> {

    public ProductsApiRestRequest(String testUrl) {
        super(testUrl);
        path("/api/products");
    }

    public ProductsApiRestResponse execute() {
        ValidatableResponse response = given()
                .get(testUrl + path)
                .then();
        return new ProductsApiRestResponse(response);
    }
}
