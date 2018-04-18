package com.harishkannarao.demo.feature_toggle.controller;

import com.harishkannarao.demo.feature_toggle.property.PropertyReader;
import com.harishkannarao.demo.feature_toggle.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    private final PropertyReader propertyReader;
    private final ProductService productService;

    public ProductController(PropertyReader propertyReader, ProductService productService) {
        this.propertyReader = propertyReader;
        this.productService = productService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView displayProductList() {
        ModelMap model = new ModelMap();
        model.put("products", productService.getAllProducts());
        if (propertyReader.displayHiddenProducts()) {
            model.put("displayBanner", true);
        }
        return new ModelAndView("homePage", model);
    }
}
