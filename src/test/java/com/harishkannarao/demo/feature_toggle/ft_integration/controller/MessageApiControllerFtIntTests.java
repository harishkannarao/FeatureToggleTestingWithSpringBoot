package com.harishkannarao.demo.feature_toggle.ft_integration.controller;

import com.harishkannarao.demo.feature_toggle.ft_integration.AbstractBaseFtIntProfile;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class MessageApiControllerFtIntTests extends AbstractBaseFtIntProfile {

    @Test
    void get_messages_returns_hidden_product_message() {
        final Response response = given()
                .when()
                .get("/api/messages")
                .andReturn();

        assertThat(response.statusCode()).isEqualTo(200);
        final String[] messages = response.as(String[].class);
        assertThat(messages)
                .containsExactlyInAnyOrder(
                        "Available Products",
                        "New products available for sale !!!");
    }

}
