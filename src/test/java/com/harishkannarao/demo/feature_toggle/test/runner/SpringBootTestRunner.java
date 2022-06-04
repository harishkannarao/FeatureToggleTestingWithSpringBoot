package com.harishkannarao.demo.feature_toggle.test.runner;

import com.harishkannarao.demo.feature_toggle.FeatureToggleTestingDemoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.core.env.Environment;

import java.util.Optional;
import java.util.Properties;

public class SpringBootTestRunner {
    private static ConfigurableApplicationContext context;
    private static Properties properties;

    public static void stop() {
        if (isRunning()) {
            SpringApplication.exit(context);
        }
    }

    public static void start(Properties value) {
        String[] args = value.entrySet().stream().map(entry -> String.format("--%s=%s", entry.getKey(), entry.getValue())).toArray(String[]::new);
        context = SpringApplication.run(FeatureToggleTestingDemoApplication.class, args);
        properties = value;
    }

    public static void restart(Properties properties) {
        stop();
        start(properties);
    }

    public static boolean isRunning() {
        return Optional.ofNullable(context)
                .map(Lifecycle::isRunning)
                .orElse(false);
    }

    public static Properties getProperties() {
        return properties;
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public static String getPort() {
        return getBean(Environment.class).getProperty("local.server.port");
    }

    public static String getApplicationUrl() {
        return String.format("http://localhost:%s", getPort());
    }
}
