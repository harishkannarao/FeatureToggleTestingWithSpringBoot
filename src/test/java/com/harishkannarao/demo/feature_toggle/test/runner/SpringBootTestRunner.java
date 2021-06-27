package com.harishkannarao.demo.feature_toggle.test.runner;

import com.harishkannarao.demo.feature_toggle.FeatureToggleTestingDemoApplication;
import com.harishkannarao.demo.feature_toggle.test.configuration.IntegrationTestConfiguration;
import org.assertj.core.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpringBootTestRunner {
    private static final SpringBootTestRunner INSTANCE = new SpringBootTestRunner();

    public static SpringBootTestRunner getSingletonInstance() {
        return INSTANCE;
    }

    private ConfigurableApplicationContext context;
    private String[] properties;

    public void stop() {
        if (isRunning()) {
            SpringApplication.exit(context);
        }
    }

    public void start(List<String> properties) {
        String[] propertiesArray = properties.toArray(String[]::new);
        context = SpringApplication.run(FeatureToggleTestingDemoApplication.class, propertiesArray);
        this.properties = propertiesArray;
    }

    public void restart(List<String> properties) {
        stop();
        start(properties);
    }

    public boolean isRunning() {
        return Optional.ofNullable(context)
                .map(Lifecycle::isRunning)
                .orElse(false);
    }

    public List<String> getProperties() {
        if (properties != null) {
            return Stream.of(properties).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }
}
