package com.project.full.ComputerShoping.controller;

import com.project.full.ComputerShoping.model.Computer;
import com.project.full.ComputerShoping.service.ComputerDaoService;
import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/shop_user")
public class GuestController {

    private final ComputerDaoService computerDaoService;

    public GuestController(ComputerDaoService computerDaoService) {
        this.computerDaoService = computerDaoService;
    }

    @GetMapping("/computer_page")
    public String getComputerPage(Model model){
        model.addAttribute("computerList",computerDaoService.getComputerList());
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
        int pic_name_count = computerDaoService.checkImageName(multipartFile.getOriginalFilename());

        String pic_name = computerDaoService.addComputerImage(multipartFile,pic_name_count);
        computer.setPhoto_name_string(pic_name);
        computerDaoService.addComputer(computer);
        return "redirect:/shop_user/computer_page";
    }
}
