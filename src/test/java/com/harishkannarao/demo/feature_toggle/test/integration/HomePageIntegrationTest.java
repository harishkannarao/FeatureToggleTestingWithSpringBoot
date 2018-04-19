package com.harishkannarao.demo.feature_toggle.test.integration;

import com.harishkannarao.demo.feature_toggle.test.property.TestPropertyReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.harishkannarao.demo.feature_toggle.test.constants.TestProducts.*;

public class HomePageIntegrationTest extends AbstractBaseIntegrationTest {

    @Autowired
    private TestPropertyReader testPropertyReader;

    @Before
    @After
    public void resetPropertyReader() {
        testPropertyReader.resetDisplayHiddenProduct();
    }

    @Test
    public void should_display_banner_message_when_enabled_through_property() {
        testPropertyReader.setDisplayHiddenProduct(true);

        pageObjectFactory.homePage()
                .navigate()
                .expectBannerMessage("New products available for sale !!!");
    }

    @Test
    public void should_not_display_banner_message_when_disabled_through_property() {
        testPropertyReader.setDisplayHiddenProduct(false);

        pageObjectFactory.homePage()
                .navigate()
                .expectNoBannerMessage();
    }

    @Test
    public void should_not_display_banner_message_as_default_behaviour() {
        testPropertyReader.resetDisplayHiddenProduct();

        pageObjectFactory.homePage()
                .navigate()
                .expectNoBannerMessage();
    }

    @Test
    public void should_display_hidden_products_when_enabled_through_property() {
        testPropertyReader.setDisplayHiddenProduct(true);

        pageObjectFactory.homePage()
                .navigate()
                .expectTotalProductsDisplayedOnPageToBe(4)
                .expectProductIsDisplayedOnPage(DOODLE_EXCEL)
                .expectProductIsDisplayedOnPage(DODDLE_SUCCESS_7)
                .expectProductIsDisplayedOnPage(PEARS_YPHONE)
                .expectProductIsDisplayedOnPage(PEARS_YPAD);
    }

    @Test
    public void should_not_display_hidden_products_when_disabled_through_property() {
        testPropertyReader.setDisplayHiddenProduct(false);

        pageObjectFactory.homePage()
                .navigate()
                .expectTotalProductsDisplayedOnPageToBe(2)
                .expectProductIsDisplayedOnPage(DOODLE_EXCEL)
                .expectProductIsDisplayedOnPage(DODDLE_SUCCESS_7);
    }

    @Test
    public void should_not_display_hidden_products_as_default_behaviour() {
        testPropertyReader.resetDisplayHiddenProduct();

        pageObjectFactory.homePage()
                .navigate()
                .expectTotalProductsDisplayedOnPageToBe(2)
                .expectProductIsDisplayedOnPage(DOODLE_EXCEL)
                .expectProductIsDisplayedOnPage(DODDLE_SUCCESS_7);
    }
}
