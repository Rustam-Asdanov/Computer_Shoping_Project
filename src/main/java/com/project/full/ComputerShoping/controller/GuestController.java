package com.project.full.ComputerShoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/computer_shopping/guest")
public class GuestController {

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("account","king");
        model.addAttribute("isActive",true);
        return "main";
    }
}
