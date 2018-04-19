package com.harishkannarao.demo.feature_toggle.test.factory;

import com.harishkannarao.demo.feature_toggle.test.constants.TestConstants;
import com.harishkannarao.demo.feature_toggle.test.rest.MessagesApiRestRequest;
import com.harishkannarao.demo.feature_toggle.test.rest.ProductsApiRestRequest;

public class RestClientFactory {
    public ProductsApiRestRequest productsApiRestRequest() {
        return new ProductsApiRestRequest(TestConstants.APPLICATION_TEST_URL);
    }

    public MessagesApiRestRequest messagesApiRestRequest() {
        return new MessagesApiRestRequest(TestConstants.APPLICATION_TEST_URL);
    }
}
