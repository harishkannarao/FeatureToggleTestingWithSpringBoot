package com.harishkannarao.demo.feature_toggle.test.configuration;

import com.harishkannarao.demo.feature_toggle.property.DefaultPropertyReader;
import com.harishkannarao.demo.feature_toggle.property.PropertyReader;
import com.harishkannarao.demo.feature_toggle.test.factory.PageObjectFactory;
import com.harishkannarao.demo.feature_toggle.test.factory.WebDriverFactory;
import com.harishkannarao.demo.feature_toggle.test.property.TestPropertyReader;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class IntegrationTestConfiguration {

    @Bean
    public WebDriverFactory createWebDriverFactory() {
        return new WebDriverFactory();
    }

    @Bean
    public PageObjectFactory createPageObjectFactory() {
        return new PageObjectFactory();
    }

    @Bean
    @Primary
    public PropertyReader createTestPropertyReader(DefaultPropertyReader defaultPropertyReader) {
        return new TestPropertyReader(defaultPropertyReader);
    }
}
