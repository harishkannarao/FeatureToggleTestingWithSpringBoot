package com.harishkannarao.demo.feature_toggle.test.rest;

import com.harishkannarao.demo.feature_toggle.test.constants.TestConstants;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class MessagesApiRestRequest {
    private final String testUrl;
    private final String path = "/api/messages";

    public MessagesApiRestRequest(String testUrl) {

        this.testUrl = testUrl;
    }

    public MessagesApiRestResponse execute() {
        ValidatableResponse response = given()
                .get(TestConstants.APPLICATION_TEST_URL + path)
                .then();
        return new MessagesApiRestResponse(response);
    }
}
