package com.harishkannarao.demo.feature_toggle.test.integration;

import org.junit.Test;

public class ConditionalServiceApiIntegrationTest extends AbstractBaseIntegrationTest {

    @Test
    public void returns_different_message_when_configured() {
        enableDifferentMessageService();

        restClientFactory.conditionalServiceApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectMessage("I am different!!!");
    }

    @Test
    public void returns_default_message_when_configured() {
        enableDefaultMessageService();

        restClientFactory.conditionalServiceApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectMessage("I am default!!!");
    }

    @Test
    public void returns_default_message_as_default_behaviour() {
        restClientFactory.conditionalServiceApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectMessage("I am default!!!");
    }
}
