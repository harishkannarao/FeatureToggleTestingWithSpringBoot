package com.harishkannarao.demo.feature_toggle.test.factory;

import com.harishkannarao.demo.feature_toggle.test.constants.TestConstants;
import com.harishkannarao.demo.feature_toggle.test.rest.ConditionalApiRestRequest;
import com.harishkannarao.demo.feature_toggle.test.rest.ConditionalServiceApiRestRequest;
import com.harishkannarao.demo.feature_toggle.test.rest.MessagesApiRestRequest;
import com.harishkannarao.demo.feature_toggle.test.rest.ProductsApiRestRequest;

public class RestClientFactory {
    public ProductsApiRestRequest productsApiRestRequest() {
        return new ProductsApiRestRequest(TestConstants.APPLICATION_TEST_URL);
    }

    public MessagesApiRestRequest messagesApiRestRequest() {
        return new MessagesApiRestRequest(TestConstants.APPLICATION_TEST_URL);
    }

    public ConditionalApiRestRequest conditionalApiRestRequest() {
        return new ConditionalApiRestRequest(TestConstants.APPLICATION_TEST_URL);
    }

    public ConditionalServiceApiRestRequest conditionalServiceApiRestRequest() {
        return new ConditionalServiceApiRestRequest(TestConstants.APPLICATION_TEST_URL);
    }
}
