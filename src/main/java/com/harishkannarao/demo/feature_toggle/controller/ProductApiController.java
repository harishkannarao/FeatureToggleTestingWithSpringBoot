package com.harishkannarao.demo.feature_toggle.controller;

import com.harishkannarao.demo.feature_toggle.domain.Product;
import com.harishkannarao.demo.feature_toggle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductApiController {

    private final ProductService productService;

    @Autowired
    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/api/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProductLists() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
