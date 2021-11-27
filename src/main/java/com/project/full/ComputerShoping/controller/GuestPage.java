package com.project.full.ComputerShoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/shop_user")
public class GuestPage {

    @GetMapping("/computer_page")
    public String getComputerPage(Model model){
        model.addAttribute("computerList",new ArrayList<>());
        return "computer_page";
    }
}
