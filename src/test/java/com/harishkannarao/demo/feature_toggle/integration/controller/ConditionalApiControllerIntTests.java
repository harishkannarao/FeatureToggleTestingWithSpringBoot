package com.harishkannarao.demo.feature_toggle.integration.controller;

import com.harishkannarao.demo.feature_toggle.integration.AbstractBaseDefaultIntProfile;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ConditionalApiControllerIntTests extends AbstractBaseDefaultIntProfile {

    @Test
	void get_messages_returns_404_when_disabled() {
		final Response response = given()
				.when()
				.get("/api/conditional")
				.andReturn();

		assertThat(response.statusCode()).isEqualTo(404);
	}

}
