package com.harishkannarao.demo.feature_toggle.test.runner;

import com.harishkannarao.demo.feature_toggle.FeatureToggleTestingDemoApplication;
import com.harishkannarao.demo.feature_toggle.test.configuration.IntegrationTestConfiguration;
import org.assertj.core.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;

import java.util.List;
import java.util.Optional;

public class SpringBootTestRunner {
    private static final SpringBootTestRunner INSTANCE = new SpringBootTestRunner();

    public static SpringBootTestRunner getSingletonInstance() {
        return INSTANCE;
    }

    private ConfigurableApplicationContext context;

    public void stop() {
        if (isRunning()) {
            SpringApplication.exit(context);
        }
    }

    public void start(List<String> properties) {
        context = SpringApplication.run(
                Arrays.array(
                        FeatureToggleTestingDemoApplication.class,
                        IntegrationTestConfiguration.class),
                properties.toArray(String[]::new)
        );
    }

    public boolean isRunning() {
        return Optional.ofNullable(context)
                .map(Lifecycle::isRunning)
                .orElse(false);
    }

    public <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }
}
