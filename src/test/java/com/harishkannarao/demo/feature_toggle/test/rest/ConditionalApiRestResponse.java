package com.harishkannarao.demo.feature_toggle.test.rest;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ConditionalApiRestResponse extends AbstractBaseRestResponse<ConditionalApiRestResponse> {
    ConditionalApiRestResponse(ValidatableResponse response) {
        super(response);
    }

    public ConditionalApiRestResponse expectMessage(String expectedMessage) {
        String actualMessage = response.extract().jsonPath().getString("message");
        assertThat(actualMessage, equalTo(expectedMessage));
        return this;
    }
}
