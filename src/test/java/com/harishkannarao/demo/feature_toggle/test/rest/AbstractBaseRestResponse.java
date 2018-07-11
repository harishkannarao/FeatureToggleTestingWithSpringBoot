package com.harishkannarao.demo.feature_toggle.test.rest;

import io.restassured.response.ValidatableResponse;

@SuppressWarnings("unchecked")
public abstract class AbstractBaseRestResponse<T extends AbstractBaseRestResponse> {
    final ValidatableResponse response;

    AbstractBaseRestResponse(ValidatableResponse response) {
        this.response = response;
    }

    public T expectSuccessStatusCode() {
        response.statusCode(200);
        return (T) this;
    }

    public T expectNotFoundStatusCode() {
        response.statusCode(404);
        return (T) this;
    }
}
