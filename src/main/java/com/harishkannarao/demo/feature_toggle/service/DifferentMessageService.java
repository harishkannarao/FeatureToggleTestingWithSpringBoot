package com.harishkannarao.demo.feature_toggle.service;

import com.harishkannarao.demo.feature_toggle.domain.ConditionalMessage;

public class DifferentMessageService implements MessageService {
    @Override
    public ConditionalMessage getMessage() {
        return new ConditionalMessage("I am different!!!");
    }
}
