package com.harishkannarao.demo.feature_toggle.test.integration;

import org.junit.jupiter.api.Test;

import java.util.Properties;

class MessageApiDisplayingHiddenProductsIntegrationTest extends AbstractBaseIntegrationTest {
    @Override
    protected Properties getOverriddenProperties() {
        Properties value = new Properties();
        value.put("application-config.display-hidden-products", "true");
        return value;
    }

    @Test
    public void returns_banner_message_when_enabled_through_property() {
        restClientFactory.messagesApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectBannerMessage("New products available for sale !!!");
    }
}

class MessageApiNotDisplayingHiddenProductsIntegrationTest extends AbstractBaseIntegrationTest {
    @Override
    protected Properties getOverriddenProperties() {
        Properties value = new Properties();
        value.put("application-config.display-hidden-products", "false");
        return value;
    }

    @Test
    public void does_not_returns_banner_message_when_disabled_through_property() {
        restClientFactory.messagesApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectNoBannerMessage();
    }
}

class MessageApiIntegrationTest extends AbstractBaseIntegrationTest {

    @Test
    public void returns_product_message() {
        restClientFactory.messagesApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectProductMessage("Available Products");
    }

    @Test
    public void does_not_returns_banner_message_as_default_behaviour() {
        restClientFactory.messagesApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectNoBannerMessage();
    }
}
