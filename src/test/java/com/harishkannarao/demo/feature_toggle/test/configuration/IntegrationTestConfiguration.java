package com.harishkannarao.demo.feature_toggle.test.configuration;

import com.harishkannarao.demo.feature_toggle.test.factory.PageObjectFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.WebDriverFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class IntegrationTestConfiguration {

    @Bean
    public WebDriverFactory createWebDriverFactory() {
        return new WebDriverFactory();
    }

    @Bean
    public PageObjectFactory createPageObjectFactory(WebDriverFactory webDriverFactory) {
        return new PageObjectFactory(webDriverFactory);
    }
}
