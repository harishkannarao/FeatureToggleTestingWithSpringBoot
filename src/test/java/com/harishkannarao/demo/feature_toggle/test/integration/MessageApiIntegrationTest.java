package com.harishkannarao.demo.feature_toggle.test.integration;

import org.junit.Test;

public class MessageApiIntegrationTest extends AbstractBaseIntegrationTest {

    @Test
    public void returns_product_message() {
        restClientFactory.messagesApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectProductMessage("Available Products");
    }

    @Test
    public void returns_banner_message_when_enabled_through_property() {
        displayHiddenProducts();

        restClientFactory.messagesApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectBannerMessage("New products available for sale !!!");
    }

    @Test
    public void does_not_returns_banner_message_when_disabled_through_property() {
        doNotDisplayHiddenProducts();

        restClientFactory.messagesApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectNoBannerMessage();
    }

    @Test
    public void does_not_returns_banner_message_as_default_behaviour() {
        restClientFactory.messagesApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectNoBannerMessage();
    }
}
