package com.harishkannarao.demo.feature_toggle.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class LocalTestConfiguration {

    private static final Logger log = LoggerFactory.getLogger(LocalTestConfiguration.class);

    @Bean
    public InitializingBean initForLocal() {
        return () -> {
            log.info("Initialize data setup or tasks for local");
        };
    }

    @Bean
    public DisposableBean destroyForLocal() {
        return () -> {
            log.info("Destroy any resources for local");
        };

    }
}
