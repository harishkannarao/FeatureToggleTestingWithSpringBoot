package com.harishkannarao.demo.feature_toggle.service;

import com.harishkannarao.demo.feature_toggle.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductService {

    private final boolean displayHiddenProducts;

    @Autowired
    public ProductService(@Value("${application-config.display-hidden-products}") boolean displayHiddenProducts) {
        this.displayHiddenProducts = displayHiddenProducts;
    }

    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList<>();
        if (displayHiddenProducts) {
            result.addAll(getHiddenProducts());
        }
        result.addAll(getDefaultProducts());
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
