package com.harishkannarao.demo.feature_toggle.test.property;

import com.harishkannarao.demo.feature_toggle.property.PropertyReader;

import java.util.Optional;

public class TestPropertyReader implements PropertyReader {
    private final PropertyReader propertyReader;
    private Optional<Boolean> displayHiddenProducts = Optional.empty();

    public TestPropertyReader(PropertyReader propertyReader) {
        this.propertyReader = propertyReader;
    }

    public void setDisplayHiddenProduct(boolean value) {
        displayHiddenProducts = Optional.of(value);
    }

    public void resetDisplayHiddenProduct() {
        displayHiddenProducts = Optional.empty();
    }

    @Override
    public boolean displayHiddenProducts() {
        return displayHiddenProducts.orElseGet(propertyReader::displayHiddenProducts);
    }
}
