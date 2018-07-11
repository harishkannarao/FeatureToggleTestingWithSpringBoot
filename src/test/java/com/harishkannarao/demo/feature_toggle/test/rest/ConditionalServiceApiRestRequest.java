package com.harishkannarao.demo.feature_toggle.test.rest;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ConditionalServiceApiRestRequest extends AbstractBaseRestRequest<ConditionalServiceApiRestRequest> {
    public ConditionalServiceApiRestRequest(String testUrl) {
        super(testUrl);
        path("/api/conditional/service");
    }

    public ConditionalServiceApiRestResponse execute() {
        ValidatableResponse response = given()
                .get(testUrl + path)
                .then();
        return new ConditionalServiceApiRestResponse(response);
    }
}
