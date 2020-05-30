package com.ibreeze.oauth.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/failure")
    @ResponseBody
    public String failure(){
        return "failure";
    }


    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @RequestMapping("/error2")
    @ResponseBody
    public String error(){
        return "error";
    }


}
