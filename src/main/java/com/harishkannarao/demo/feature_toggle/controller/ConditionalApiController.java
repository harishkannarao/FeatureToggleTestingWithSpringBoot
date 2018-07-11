package com.harishkannarao.demo.feature_toggle.controller;

import com.harishkannarao.demo.feature_toggle.domain.ConditionalMessage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnProperty(prefix = "conditional-api", value = {"enabled"}, havingValue = "true")
public class ConditionalApiController {

    @RequestMapping(value = "/api/conditional", method = RequestMethod.GET)
    public ResponseEntity<ConditionalMessage> getMessages() {
        ConditionalMessage conditionalMessage = new ConditionalMessage("I am available!!!");
        return new ResponseEntity<>(conditionalMessage, HttpStatus.OK);
    }
}
