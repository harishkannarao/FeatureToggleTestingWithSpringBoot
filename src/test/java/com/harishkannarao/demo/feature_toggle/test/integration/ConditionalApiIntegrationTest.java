package com.harishkannarao.demo.feature_toggle.test.integration;


import org.junit.jupiter.api.Test;

import java.util.Properties;

class ConditionalApiEnabledIntegrationTest extends AbstractBaseIntegrationTest {
    @Override
    protected Properties getOverriddenProperties() {
        Properties value = new Properties();
        value.put("conditional-api.enabled", "true");
        return value;
    }

    @Test
    public void returns_message_when_enabled() {
        restClientFactory.conditionalApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectMessage("I am available!!!");
    }
}

class ConditionalApiDisabledIntegrationTest extends AbstractBaseIntegrationTest {
    @Override
    protected Properties getOverriddenProperties() {
        Properties value = new Properties();
        value.put("conditional-api.enabled", "false");
        return value;
    }

    @Test
    public void returns_not_found_status_when_disabled() {
        restClientFactory.conditionalApiRestRequest()
                .execute()
                .expectNotFoundStatusCode();
    }
}

class ConditionalApiIntegrationTest extends AbstractBaseIntegrationTest {
    @Test
    public void returns_not_found_status_as_default_behaviour() {
        restClientFactory.conditionalApiRestRequest()
                .execute()
                .expectNotFoundStatusCode();
    }
}
