package com.harishkannarao.demo.feature_toggle.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DefaultPropertyReader implements PropertyReader {
    private final boolean displayHiddenProducts;

    @Autowired
    public DefaultPropertyReader(
            @Value("${application-config.display-hidden-products}") boolean displayHiddenProducts
    ) {
        this.displayHiddenProducts = displayHiddenProducts;
    }

    @Override
    public boolean displayHiddenProducts() {
        return displayHiddenProducts;
    }
}
