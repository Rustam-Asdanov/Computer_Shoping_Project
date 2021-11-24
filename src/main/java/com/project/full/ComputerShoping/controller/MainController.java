package com.project.full.ComputerShoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/computer_shopping")
class MainController {

    @GetMapping
    public String getMainPage(){
        return "main";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model){
        model.addAttribute("new_user","");
        return "registration";
    }

}
