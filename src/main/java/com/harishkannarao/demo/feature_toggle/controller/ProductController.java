package com.harishkannarao.demo.feature_toggle.controller;

import com.harishkannarao.demo.feature_toggle.property.PropertyReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    private final PropertyReader propertyReader;

    public ProductController(PropertyReader propertyReader) {
        this.propertyReader = propertyReader;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView displayProductList() {
        ModelMap model = new ModelMap();
        if (propertyReader.displayHiddenProducts()) {
            model.put("displayBanner", true);
        }
        return new ModelAndView("homePage", model);
    }
}
