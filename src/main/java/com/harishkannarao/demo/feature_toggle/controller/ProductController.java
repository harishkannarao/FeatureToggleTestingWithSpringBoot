package com.harishkannarao.demo.feature_toggle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView displayProductList() {
        ModelMap model = new ModelMap();
        return new ModelAndView("homePage", model);
    }
}
