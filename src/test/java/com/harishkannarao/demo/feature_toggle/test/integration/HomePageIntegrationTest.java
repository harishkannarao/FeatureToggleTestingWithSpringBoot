package com.harishkannarao.demo.feature_toggle.test.integration;

import org.junit.Test;

import static com.harishkannarao.demo.feature_toggle.test.constants.TestProducts.*;

public class HomePageIntegrationTest extends AbstractBaseIntegrationTest {

    @Test
    public void should_display_banner_message_when_enabled_through_property() {
        displayHiddenProducts();

        pageObjectFactory.homePage()
                .navigate()
                .expectBannerMessage("New products available for sale !!!");
    }

    @Test
    public void should_not_display_banner_message_when_disabled_through_property() {
        doNotDisplayHiddenProducts();

        pageObjectFactory.homePage()
                .navigate()
                .expectNoBannerMessage();
    }

    @Test
    public void should_not_display_banner_message_as_default_behaviour() {
        pageObjectFactory.homePage()
                .navigate()
                .expectNoBannerMessage();
    }

    @Test
    public void should_display_hidden_products_when_enabled_through_property() {
        displayHiddenProducts();

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
        doNotDisplayHiddenProducts();

        pageObjectFactory.homePage()
                .navigate()
                .expectTotalProductsDisplayedOnPageToBe(2)
                .expectProductIsDisplayedOnPage(DOODLE_EXCEL)
                .expectProductIsDisplayedOnPage(DODDLE_SUCCESS_7);
    }

    @Test
    public void should_not_display_hidden_products_as_default_behaviour() {
        pageObjectFactory.homePage()
                .navigate()
                .expectTotalProductsDisplayedOnPageToBe(2)
                .expectProductIsDisplayedOnPage(DOODLE_EXCEL)
                .expectProductIsDisplayedOnPage(DODDLE_SUCCESS_7);
    }
}
