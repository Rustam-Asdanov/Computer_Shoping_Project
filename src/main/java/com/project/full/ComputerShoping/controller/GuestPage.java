package com.project.full.ComputerShoping.controller;

import com.project.full.ComputerShoping.model.Computer;
import com.project.full.ComputerShoping.service.ComputerDaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/shop_user")
public class GuestPage {

    private final ComputerDaoService computerDaoService;

    public GuestPage(ComputerDaoService computerDaoService) {
        this.computerDaoService = computerDaoService;
    }

    @GetMapping("/computer_page")
    public String getComputerPage(Model model){
        model.addAttribute("computerList",new ArrayList<>());
        return "computer_page";
    }

    @GetMapping("/new_computer")
    public String getNewComputerPage(Model model){
        model.addAttribute("computer",new Computer());
        return "new_computer";
    }

    @PostMapping("/add_computer")
    public String addNewComputer(@ModelAttribute @Valid Computer computer,
                                 BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return "new_computer";
        }

        computerDaoService.addComputer(computer);
        return "forward:/shop_user/computer_page";
    }
}
