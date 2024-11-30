package com.harishkannarao.demo.feature_toggle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageApiController {

    private final boolean displayHiddenProducts;

    @Autowired
    public MessageApiController(
            @Value("${feature-flags.display-hidden-products}") boolean displayHiddenProducts) {
        this.displayHiddenProducts = displayHiddenProducts;
    }

    @RequestMapping(value = "/api/messages", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getMessages() {
        final List<String> messages;
        if (displayHiddenProducts) {
            messages = List.of("Available Products", "New products available for sale !!!");
        } else {
            messages = List.of("Available Products");

        }
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}
