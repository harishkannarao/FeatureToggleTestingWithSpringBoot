package com.harishkannarao.demo.feature_toggle.test.rest;

import io.restassured.response.ValidatableResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class ConditionalServiceApiRestResponse extends AbstractBaseRestResponse<ConditionalServiceApiRestResponse> {
    ConditionalServiceApiRestResponse(ValidatableResponse response) {
        super(response);
    }

    public ConditionalServiceApiRestResponse expectMessage(String expectedMessage) {
        String actualMessage = response.extract().jsonPath().getString("message");
        assertThat(actualMessage).isEqualTo(expectedMessage);
        return this;
    }
}
