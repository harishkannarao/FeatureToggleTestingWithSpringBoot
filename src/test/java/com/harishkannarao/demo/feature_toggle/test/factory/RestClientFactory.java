package com.harishkannarao.demo.feature_toggle.test.factory;

import com.harishkannarao.demo.feature_toggle.test.rest.ConditionalApiRestRequest;
import com.harishkannarao.demo.feature_toggle.test.rest.ConditionalServiceApiRestRequest;
import com.harishkannarao.demo.feature_toggle.test.rest.MessagesApiRestRequest;
import com.harishkannarao.demo.feature_toggle.test.rest.ProductsApiRestRequest;

public class RestClientFactory {
    private final String applicationUrl;

    public RestClientFactory(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }

    public ProductsApiRestRequest productsApiRestRequest() {
        return new ProductsApiRestRequest(applicationUrl);
    }

    public MessagesApiRestRequest messagesApiRestRequest() {
        return new MessagesApiRestRequest(applicationUrl);
    }

    public ConditionalApiRestRequest conditionalApiRestRequest() {
        return new ConditionalApiRestRequest(applicationUrl);
    }

    public ConditionalServiceApiRestRequest conditionalServiceApiRestRequest() {
        return new ConditionalServiceApiRestRequest(applicationUrl);
    }
}
