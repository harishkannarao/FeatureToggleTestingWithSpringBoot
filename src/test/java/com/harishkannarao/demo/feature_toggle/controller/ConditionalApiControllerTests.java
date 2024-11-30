package com.harishkannarao.demo.feature_toggle.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConditionalApiControllerTests {

    private final ConditionalApiController underTest = new ConditionalApiController();

    @Test
    public void test_getMessages_returns_expected_message() {
        final ResponseEntity<List<String>> result = underTest.getMessages();

        assertThat(result.getStatusCode().value()).isEqualTo(200);

        assertThat(result.getBody())
                .containsExactlyInAnyOrder("I am available!!!");
    }
}
