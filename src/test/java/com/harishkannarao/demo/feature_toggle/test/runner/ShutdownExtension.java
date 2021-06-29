package com.harishkannarao.demo.feature_toggle.test.runner;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class ShutdownExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    private static boolean started = false;

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        if (!started) {
            started = true;
            // Your "before all tests" startup logic goes here
            // The following line registers a callback hook when the root test context is shut down
            extensionContext.getRoot().getStore(GLOBAL).put("SHUTDOWN_EXTENSION", this);
        }
    }

    @Override
    public void close() {
        SpringBootTestRunner.stop();
    }
}
