package com.harishkannarao.demo.feature_toggle.domain;

public class ConditionalMessage {
    private final String message;

    public ConditionalMessage(String message) {
        this.message = message;
    }

    @SuppressWarnings("unused")
    public String getMessage() {
        return message;
    }
}
