package com.harishkannarao.demo.feature_toggle.test.rest;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ConditionalApiRestRequest extends AbstractBaseRestRequest<ConditionalApiRestRequest> {
    public ConditionalApiRestRequest(String testUrl) {
        super(testUrl);
        path("/api/conditional");
    }

    public ConditionalApiRestResponse execute() {
        ValidatableResponse response = given()
                .get(testUrl + path)
                .then();
        return new ConditionalApiRestResponse(response);
    }
}
