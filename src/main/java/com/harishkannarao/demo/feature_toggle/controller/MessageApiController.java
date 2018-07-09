package com.harishkannarao.demo.feature_toggle.controller;

import com.harishkannarao.demo.feature_toggle.domain.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageApiController {

    private final boolean displayHiddenProducts;

    @Autowired
    public MessageApiController(@Value("${application-config.display-hidden-products}") boolean displayHiddenProducts) {
        this.displayHiddenProducts = displayHiddenProducts;
    }

    @RequestMapping(value = "/api/messages", method = RequestMethod.GET)
    public ResponseEntity<Messages> getMessages() {
        Messages messages;
        if (displayHiddenProducts) {
            messages = new Messages("Available Products", "New products available for sale !!!");
        } else {
            messages = new Messages("Available Products");

        }
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}
