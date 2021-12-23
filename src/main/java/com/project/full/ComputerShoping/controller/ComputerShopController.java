package com.project.full.ComputerShoping.controller;

import com.project.full.ComputerShoping.service.ComputerDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/computer/shop")
public class ComputerShopController {

    @Autowired
    private ComputerDaoService computerDaoService;

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("computer_info_list",
                computerDaoService.getComputerListForShop(0));
        return "/computer_shop";
    }
}
