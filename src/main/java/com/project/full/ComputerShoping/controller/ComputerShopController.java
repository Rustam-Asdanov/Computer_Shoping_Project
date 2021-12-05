package com.project.full.ComputerShoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/computer/shop")
public class ComputerShopController {

    @GetMapping
    public String getPage(){
        return "/computer_shop";
    }
}
