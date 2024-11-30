package com.harishkannarao.demo.feature_toggle.integration.controller;

import com.harishkannarao.demo.feature_toggle.integration.AbstractBaseDefaultIntProfile;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class MessageApiControllerIntTests extends AbstractBaseDefaultIntProfile {

    @Test
	void get_messages_returns_only_default_messages() {
		final Response response = given()
				.when()
				.get("/api/messages")
				.andReturn();

		assertThat(response.statusCode()).isEqualTo(200);
		final String[] messages = response.as(String[].class);
		assertThat(messages)
				.containsExactlyInAnyOrder("Available Products");
	}

}
