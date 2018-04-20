package com.harishkannarao.demo.feature_toggle.test.rest;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class MessagesApiRestRequest extends AbstractBaseRestRequest<MessagesApiRestRequest> {
    public MessagesApiRestRequest(String testUrl) {
        super(testUrl);
        path("/api/messages");
    }

    public MessagesApiRestResponse execute() {
        ValidatableResponse response = given()
                .get(testUrl + path)
                .then();
        return new MessagesApiRestResponse(response);
    }
}
