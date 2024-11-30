package com.harishkannarao.demo.feature_toggle.integration;

import com.harishkannarao.demo.feature_toggle.AbstractBaseIntTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles = {"int-test"})
public abstract class AbstractBaseDefaultIntProfile extends AbstractBaseIntTest {
}
