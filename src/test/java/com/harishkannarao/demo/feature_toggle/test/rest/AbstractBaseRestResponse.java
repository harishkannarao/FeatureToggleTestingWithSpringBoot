package com.harishkannarao.demo.feature_toggle.test.rest;

import io.restassured.response.ValidatableResponse;

public abstract class AbstractBaseRestResponse<T extends AbstractBaseRestResponse> {
    protected final ValidatableResponse response;

    public AbstractBaseRestResponse(ValidatableResponse response) {
        this.response = response;
    }

    public T expectSuccessStatusCode() {
        response.statusCode(200);
        return (T) this;
    }
}
