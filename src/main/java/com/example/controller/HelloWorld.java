package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloWorld {

    @RequestMapping(value = "/hello-world",method = RequestMethod.GET)
    public String helloWorld(Model model){
        model.addAttribute("helloworld","Hello,World!");
        return "helloworld";
    }

}
