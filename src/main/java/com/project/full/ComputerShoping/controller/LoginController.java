package com.project.full.ComputerShoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class LoginController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }


}
