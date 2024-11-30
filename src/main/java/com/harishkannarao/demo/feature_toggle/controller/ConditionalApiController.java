package com.harishkannarao.demo.feature_toggle.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ConditionalOnProperty(name = "feature-flags.enable-conditional-api", havingValue = "true")
public class ConditionalApiController {

    @RequestMapping(value = "/api/conditional", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getMessages() {
        List<String> conditionalMessage = List.of("I am available!!!");
        return new ResponseEntity<>(conditionalMessage, HttpStatus.OK);
    }
}
