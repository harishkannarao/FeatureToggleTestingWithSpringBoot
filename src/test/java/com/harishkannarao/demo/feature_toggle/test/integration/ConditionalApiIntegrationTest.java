package com.harishkannarao.demo.feature_toggle.test.integration;


import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class ConditionalApiEnabledIntegrationTest extends AbstractBaseIntegrationTest {
    @Override
    protected List<String> getOverriddenProperties() {
        return Collections.singletonList("--conditional-api.enabled=true");
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
    protected List<String> getOverriddenProperties() {
        return Collections.singletonList("--conditional-api.enabled=false");
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
