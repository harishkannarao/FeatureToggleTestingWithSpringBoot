package com.harishkannarao.demo.feature_toggle.test.integration;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.harishkannarao.demo.feature_toggle.test.constants.TestProducts.*;

class ProductsApiDisplayingHiddenProductsIntegrationTest extends AbstractBaseIntegrationTest {
    @Override
    protected List<String> getOverriddenProperties() {
        return Collections.singletonList("--application-config.display-hidden-products=true");
    }

    @Test
    public void returns_hidden_products_when_enabled_through_property() {
        restClientFactory.productsApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectTotalProductsToBe(4)
                .expectProduct(DOODLE_EXCEL)
                .expectProduct(DODDLE_SUCCESS_7)
                .expectProduct(PEARS_YPAD)
                .expectProduct(PEARS_YPHONE);
    }
}

class ProductsApiNotDisplayingHiddenProductsIntegrationTest extends AbstractBaseIntegrationTest {
    @Override
    protected List<String> getOverriddenProperties() {
        return Collections.singletonList("--application-config.display-hidden-products=false");
    }

    @Test
    public void does_not_returns_hidden_products_when_disabled_through_property() {
        restClientFactory.productsApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectTotalProductsToBe(2)
                .expectProduct(DOODLE_EXCEL)
                .expectProduct(DODDLE_SUCCESS_7);
    }
}

class ProductsApiIntegrationTest extends AbstractBaseIntegrationTest {
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
