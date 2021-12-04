package com.project.full.ComputerShoping.controller;

import com.project.full.ComputerShoping.model.Computer;
import com.project.full.ComputerShoping.service.AccountDaoService;
import com.project.full.ComputerShoping.service.ComputerDaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computer")
public class ComputerPageRestController {

    private final ComputerDaoService computerDaoService;
    private final AccountDaoService accountDaoService;

    public ComputerPageRestController(ComputerDaoService computerDaoService, AccountDaoService accountDaoService) {
        this.computerDaoService = computerDaoService;
        this.accountDaoService = accountDaoService;
    }

    @GetMapping("/{id}")
    public void deleteById(@PathVariable("id") long id){
        System.out.println("delete");
        computerDaoService.deleteComputerById(id);
    }

    private static int counter = 0;
    @GetMapping("/load/{count}")
    public List<Computer> loadComputers(
            @PathVariable("count") int count){

        long id = accountDaoService.getCurrentUserAccount().getId();

        if(count<0 && count<counter){
            counter -= count;
        } else {
            counter += count;
        }

        return computerDaoService.getComputerList(id,count);
    }

}
