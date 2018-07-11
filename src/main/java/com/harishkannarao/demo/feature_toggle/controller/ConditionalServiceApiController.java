package com.harishkannarao.demo.feature_toggle.controller;

import com.harishkannarao.demo.feature_toggle.domain.ConditionalMessage;
import com.harishkannarao.demo.feature_toggle.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConditionalServiceApiController {

    private final MessageService messageService;

    public ConditionalServiceApiController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "/api/conditional/service", method = RequestMethod.GET)
    public ResponseEntity<ConditionalMessage> getMessages() {
        ConditionalMessage conditionalMessage = messageService.getMessage();
        return new ResponseEntity<>(conditionalMessage, HttpStatus.OK);
    }
}
