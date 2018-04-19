package com.harishkannarao.demo.feature_toggle.test.factory;

import com.harishkannarao.demo.feature_toggle.test.constants.TestConstants;
import com.harishkannarao.demo.feature_toggle.test.rest.ProductsApiRestRequest;

public class RestClientFactory {
    public ProductsApiRestRequest createProductsApiRestRequest() {
        return new ProductsApiRestRequest(TestConstants.APPLICATION_TEST_URL);
    }
}
