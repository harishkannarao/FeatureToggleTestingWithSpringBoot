package com.harishkannarao.demo.feature_toggle.controller;

import com.harishkannarao.demo.feature_toggle.domain.Messages;
import com.harishkannarao.demo.feature_toggle.property.PropertyReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageApiController {

    private final PropertyReader propertyReader;

    @Autowired
    public MessageApiController(PropertyReader propertyReader) {
        this.propertyReader = propertyReader;
    }

    @RequestMapping(value = "/api/messages", method = RequestMethod.GET)
    public ResponseEntity<Messages> getMessages() {
        Messages messages;
        if (propertyReader.displayHiddenProducts()) {
            messages = new Messages("Available Products", "New products available for sale !!!");
        } else {
            messages = new Messages("Available Products");

        }
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}
