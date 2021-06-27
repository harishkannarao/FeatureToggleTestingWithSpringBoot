package com.harishkannarao.demo.feature_toggle.test.integration;


import org.junit.jupiter.api.Test;

public class ConditionalApiIntegrationTest extends AbstractBaseIntegrationTest {

    @Test
    public void returns_message_when_enabled() {
        enableConditionalApi();

        restClientFactory.conditionalApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectMessage("I am available!!!");
    }

    @Test
    public void returns_not_found_status_when_disabled() {
        disableConditionalApi();

        restClientFactory.conditionalApiRestRequest()
                .execute()
                .expectNotFoundStatusCode();
    }

    @Test
    public void returns_not_found_status_as_default_behaviour() {
        restClientFactory.conditionalApiRestRequest()
                .execute()
                .expectNotFoundStatusCode();
    }
}
