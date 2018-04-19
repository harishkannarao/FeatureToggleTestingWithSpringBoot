package com.harishkannarao.demo.feature_toggle.test.integration;

import com.harishkannarao.demo.feature_toggle.test.property.TestPropertyReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.harishkannarao.demo.feature_toggle.test.constants.TestProducts.*;

public class ProductsApiIntegrationTest extends AbstractBaseIntegrationTest {
    @Autowired
    private TestPropertyReader testPropertyReader;

    @Before
    @After
    public void resetPropertyReader() {
        testPropertyReader.resetDisplayHiddenProduct();
    }

    @Test
    public void should_display_hidden_products_when_enabled_through_property() {
        testPropertyReader.setDisplayHiddenProduct(true);

        restClientFactory.createProductsApiRestRequest()
            .execute()
            .expectSuccessStatusCode()
            .expectTotalProductsToBe(4)
            .expectProduct(DOODLE_EXCEL)
            .expectProduct(DODDLE_SUCCESS_7)
            .expectProduct(PEARS_YPAD)
            .expectProduct(PEARS_YPHONE);
    }

    @Test
    public void should_not_display_hidden_products_when_disabled_through_property() {
        testPropertyReader.setDisplayHiddenProduct(false);

        restClientFactory.createProductsApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectTotalProductsToBe(2)
                .expectProduct(DOODLE_EXCEL)
                .expectProduct(DODDLE_SUCCESS_7);
    }

    @Test
    public void should_not_display_hidden_products_as_default_behaviour() {
        testPropertyReader.resetDisplayHiddenProduct();

        restClientFactory.createProductsApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectTotalProductsToBe(2)
                .expectProduct(DOODLE_EXCEL)
                .expectProduct(DODDLE_SUCCESS_7);
    }
}
