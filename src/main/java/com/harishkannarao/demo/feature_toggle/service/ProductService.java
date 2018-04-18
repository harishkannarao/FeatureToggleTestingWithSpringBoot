package com.harishkannarao.demo.feature_toggle.service;

import com.harishkannarao.demo.feature_toggle.domain.Product;
import com.harishkannarao.demo.feature_toggle.property.PropertyReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductService {

    private final PropertyReader propertyReader;

    @Autowired
    public ProductService(PropertyReader propertyReader) {
        this.propertyReader = propertyReader;
    }

    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList<>(getDefaultProducts());
        if (propertyReader.displayHiddenProducts()) {
            result.addAll(getHiddenProducts());
        }
        return result;
    }

    private List<Product> getDefaultProducts() {
        return Arrays.asList(
                new Product("Doodle Excel", "Smartest phone from Doodle"),
                new Product("Doodle Success 7", "Smartest tablet from Doodle")
        );
    }

    private List<Product> getHiddenProducts() {
        return Arrays.asList(
                new Product("Pears yPhone", "Amazing phone ever built by Pears"),
                new Product("Pears yPad", "Amazing pad every built by Pears")
        );
    }

}
