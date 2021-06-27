package com.harishkannarao.demo.feature_toggle.test.integration;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class ConditionalServiceApiWithDifferentNameIntegrationTest extends AbstractBaseIntegrationTest {
    @Override
    protected List<String> getTestProperties() {
        return Collections.singletonList("--conditional-service.name=different");
    }

    @Test
    public void returns_different_message_when_configured() {
        restClientFactory.conditionalServiceApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectMessage("I am different!!!");
    }
}

class ConditionalServiceApiWithDefaultNameIntegrationTest extends AbstractBaseIntegrationTest {
    @Override
    protected List<String> getTestProperties() {
        return Collections.singletonList("--conditional-service.name=default");
    }

    @Test
    public void returns_default_message_when_configured() {
        restClientFactory.conditionalServiceApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectMessage("I am default!!!");
    }
}

class ConditionalServiceApiIntegrationTest extends AbstractBaseIntegrationTest {
    @Test
    public void returns_default_message_as_default_behaviour() {
        restClientFactory.conditionalServiceApiRestRequest()
                .execute()
                .expectSuccessStatusCode()
                .expectMessage("I am default!!!");
    }
}
