package com.harishkannarao.demo.feature_toggle.controller;

import com.harishkannarao.demo.feature_toggle.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    private final ProductService productService;
    private final boolean displayHiddenProducts;

    public ProductController(
            ProductService productService,
            @Value("${application-config.display-hidden-products}") boolean displayHiddenProducts) {
        this.productService = productService;
        this.displayHiddenProducts = displayHiddenProducts;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView displayProductList() {
        ModelMap model = new ModelMap();
        model.put("products", productService.getAllProducts());
        if (displayHiddenProducts) {
            model.put("displayBanner", true);
        }
        return new ModelAndView("homePage", model);
    }
}
