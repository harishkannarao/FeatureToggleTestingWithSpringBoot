package com.harishkannarao.demo.feature_toggle.test.integration;

import org.junit.jupiter.api.Test;

import java.util.Properties;

import static com.harishkannarao.demo.feature_toggle.test.constants.TestProducts.*;

class HomePageDisplayingHiddenProductsIntegrationTest extends AbstractBaseIntegrationTest {

    @Override
    protected Properties getOverriddenProperties() {
        Properties value = new Properties();
        value.put("application-config.display-hidden-products", "true");
        return value;
    }

    @Test
    public void should_display_banner_message_when_enabled_through_property() {
        pageObjectFactory.homePage()
                .navigate()
                .expectBannerMessage("New products available for sale !!!");
    }

    @Test
    public void should_display_hidden_products_when_enabled_through_property() {
        pageObjectFactory.homePage()
                .navigate()
                .expectTotalProductsDisplayedOnPageToBe(4)
                .expectProductIsDisplayedOnPage(DOODLE_EXCEL)
                .expectProductIsDisplayedOnPage(DODDLE_SUCCESS_7)
                .expectProductIsDisplayedOnPage(PEARS_YPHONE)
                .expectProductIsDisplayedOnPage(PEARS_YPAD);
    }
}

class HomePageNotDisplayingHiddenProductsIntegrationTest extends AbstractBaseIntegrationTest {

    @Override
    protected Properties getOverriddenProperties() {
        Properties value = new Properties();
        value.put("application-config.display-hidden-products", "false");
        return value;
    }

    @Test
    public void should_not_display_banner_message_when_disabled_through_property() {
        pageObjectFactory.homePage()
                .navigate()
                .expectNoBannerMessage();
    }

    @Test
    public void should_not_display_hidden_products_when_disabled_through_property() {
        pageObjectFactory.homePage()
                .navigate()
                .expectTotalProductsDisplayedOnPageToBe(2)
                .expectProductIsDisplayedOnPage(DOODLE_EXCEL)
                .expectProductIsDisplayedOnPage(DODDLE_SUCCESS_7);
    }
}

public class HomePageIntegrationTest extends AbstractBaseIntegrationTest {
    @Test
    public void should_not_display_banner_message_as_default_behaviour() {
        pageObjectFactory.homePage()
                .navigate()
                .expectNoBannerMessage();
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
