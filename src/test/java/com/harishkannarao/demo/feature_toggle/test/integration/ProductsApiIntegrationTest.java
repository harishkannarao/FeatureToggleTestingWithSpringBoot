package com.harishkannarao.demo.feature_toggle.test.integration;

import org.junit.jupiter.api.Test;

import static com.harishkannarao.demo.feature_toggle.test.constants.TestProducts.*;

public class ProductsApiIntegrationTest extends AbstractBaseIntegrationTest {

    @Test
    public void returns_hidden_products_when_enabled_through_property() {
        displayHiddenProducts();

        restClientFactory.productsApiRestRequest()
            .execute()
            .expectSuccessStatusCode()
            .expectTotalProductsToBe(4)
            .expectProduct(DOODLE_EXCEL)
            .expectProduct(DODDLE_SUCCESS_7)
            .expectProduct(PEARS_YPAD)
            .expectProduct(PEARS_YPHONE);
    }

    @Test
    public void does_not_returns_hidden_products_when_disabled_through_property() {
        doNotDisplayHiddenProducts();

        restClientFactory.productsApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectTotalProductsToBe(2)
                .expectProduct(DOODLE_EXCEL)
                .expectProduct(DODDLE_SUCCESS_7);
    }

    @Test
    public void does_not_returns_hidden_products_as_default_behaviour() {
        restClientFactory.productsApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectTotalProductsToBe(2)
                .expectProduct(DOODLE_EXCEL)
                .expectProduct(DODDLE_SUCCESS_7);
    }
}
