package com.ibreeze.oauth.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Secured("ROEL_PRODUCT")
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(){
        return "product-list";
    }

}
