package com.harishkannarao.demo.feature_toggle.integration;

import com.harishkannarao.demo.feature_toggle.AbstractBaseIntTest;
import com.harishkannarao.demo.feature_toggle.configuration.RestAssuredTestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles = {"int-test"})
@Import(value = {
        RestAssuredTestConfiguration.class
})
public abstract class AbstractBaseDefaultIntProfile extends AbstractBaseIntTest {
}
