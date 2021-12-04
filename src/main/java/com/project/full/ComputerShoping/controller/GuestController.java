package com.project.full.ComputerShoping.controller;

import com.project.full.ComputerShoping.model.Computer;
import com.project.full.ComputerShoping.service.AccountDaoService;
import com.project.full.ComputerShoping.service.ComputerDaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/shop_user")
public class GuestController {

    private final AccountDaoService accountDaoService;
    private final ComputerDaoService computerDaoService;

    public GuestController(AccountDaoService accountDaoService, ComputerDaoService computerDaoService) {
        this.accountDaoService = accountDaoService;
        this.computerDaoService = computerDaoService;
    }


    @GetMapping("/computer_page")
    public String getComputerPage(Model model){
        long id = accountDaoService.getCurrentUserAccount().getId();
        model.addAttribute("computerList",computerDaoService.getComputerList(id,0));
        return "computer_page";
    }

    @GetMapping("/new_computer")
    public String getNewComputerPage(Model model){
        model.addAttribute("computer",new Computer());
        return "new_computer";
    }

    @PostMapping("/add_computer")
    public String addNewComputer(@ModelAttribute @Valid Computer computer,
                                 BindingResult bindingResult,
                                 @RequestParam("photo_name")MultipartFile multipartFile)
    {
        System.out.println(multipartFile.getOriginalFilename());
        if(bindingResult.hasErrors()) {
            System.out.println("error");
            return "new_computer";
        }
        int pic_name_count = computerDaoService.checkImageName(Objects.requireNonNull(multipartFile.getOriginalFilename()));

        String pic_name = computerDaoService.addComputerImage(multipartFile,pic_name_count);
        computer.setPhoto_name_string(pic_name);

        computer.setTheAccount(accountDaoService.getCurrentUserAccount());

        computerDaoService.addComputer(computer);
        return "redirect:/shop_user/computer_page";
    }

    @GetMapping("/update/{id}")
    public String updateComputer(@PathVariable("id") long id, Model model){
        model.addAttribute("computer",computerDaoService.getComputerById(id));
        model.addAttribute("update",true);
        return "new_computer";
    }
}
