package com.project.full.ComputerShoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping
    public String getPage(){
        return "forward:/computer_shopping";
    }
}
