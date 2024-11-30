package com.harishkannarao.demo.feature_toggle.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageApiControllerTests {
    private final MessageApiController underTest = new MessageApiController(false);
    private final MessageApiController underTestWithFeatureOn = new MessageApiController(true);

    @Test
    void get_messages_returns_only_default_messages_with_feature_off() {
        final ResponseEntity<List<String>> result = underTest.getMessages();
        assertThat(result.getStatusCode().value()).isEqualTo(200);
        final List<String> messages = result.getBody();
        assertThat(messages)
                .containsExactlyInAnyOrder("Available Products");
    }

    @Test
    void get_messages_returns_only_default_messages_with_feature_on() {
        final ResponseEntity<List<String>> result = underTestWithFeatureOn.getMessages();
        assertThat(result.getStatusCode().value()).isEqualTo(200);
        final List<String> messages = result.getBody();
        assertThat(messages)
                .containsExactlyInAnyOrder(
                        "Available Products", "New products available for sale !!!");
    }
}
