package com.harishkannarao.demo.feature_toggle.ft_integration;

import com.harishkannarao.demo.feature_toggle.AbstractBaseIntTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles = {"int-test", "ft-int-test"})
public abstract class AbstractBaseFtIntProfile extends AbstractBaseIntTest {
}
