package com.harishkannarao.demo.feature_toggle.test.rest;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class MessagesApiRestResponse {
    private final ValidatableResponse response;

    public MessagesApiRestResponse(ValidatableResponse response) {

        this.response = response;
    }

    public MessagesApiRestResponse expectBannerMessage(String message) {
        response.body("bannerMessage", equalTo(message));
        return this;
    }

    public MessagesApiRestResponse expectNoBannerMessage() {
        response.body("bannerMessage", nullValue());
        return this;
    }

    public MessagesApiRestResponse expectSuccessStatus() {
        response.statusCode(200);
        return this;
    }

    public MessagesApiRestResponse expectProductMessage(String message) {
        response.body("productMessage", equalTo(message));
        return this;
    }
}
