package com.project.full.ComputerShoping.controller;

import com.project.full.ComputerShoping.model.Account;
import com.project.full.ComputerShoping.service.AccountDaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/computer_shopping")
class MainController {

    private final AccountDaoService accountDaoService;

    MainController(AccountDaoService accountDaoService) {
        this.accountDaoService = accountDaoService;
    }

    @GetMapping
    public String getMainPage(){
        return "main";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model){
        model.addAttribute("new_user",new Account());
        return "registration";
    }

    @PostMapping("/create_account")
    public String createAccount(@ModelAttribute("new_user") Account account){
        accountDaoService.createNewAccount(account);
        System.out.println("saved");
        return "redirect:/login";
    }



}
