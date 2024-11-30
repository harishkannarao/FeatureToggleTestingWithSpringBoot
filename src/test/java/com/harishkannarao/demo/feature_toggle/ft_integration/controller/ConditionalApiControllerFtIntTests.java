package com.harishkannarao.demo.feature_toggle.ft_integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harishkannarao.demo.feature_toggle.ft_integration.AbstractBaseFtIntProfile;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ConditionalApiControllerFtIntTests extends AbstractBaseFtIntProfile {

    private final ObjectMapper objectMapper;

    @Autowired
    public ConditionalApiControllerFtIntTests(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Test
    void get_messages_returns_message_when_enabled() throws Exception {
        final Response response = given()
                .when()
                .get("/api/conditional")
                .andReturn();

        assertThat(response.statusCode()).isEqualTo(200);
        final String[] messages = objectMapper.readValue(response.getBody().asString(), String[].class);
        assertThat(messages)
                .containsExactlyInAnyOrder("I am available!!!");
    }

}
