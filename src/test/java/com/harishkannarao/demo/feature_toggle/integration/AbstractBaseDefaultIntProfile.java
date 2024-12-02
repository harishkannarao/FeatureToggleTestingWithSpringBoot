package com.harishkannarao.demo.feature_toggle.integration;

import com.harishkannarao.demo.feature_toggle.AbstractBaseIntTest;
import com.harishkannarao.demo.feature_toggle.configuration.TestRestTemplateConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles = {"int-test"})
@Import(value = {
        TestRestTemplateConfiguration.class
})
public abstract class AbstractBaseDefaultIntProfile extends AbstractBaseIntTest {
}
