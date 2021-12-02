package com.project.full.ComputerShoping.controller;

import com.project.full.ComputerShoping.model.Computer;
import com.project.full.ComputerShoping.service.ComputerDaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computer")
public class ComputerPageRestController {

    private final ComputerDaoService computerDaoService;

    public ComputerPageRestController(ComputerDaoService computerDaoService) {
        this.computerDaoService = computerDaoService;
    }

    @GetMapping("/{id}")
    public void deleteById(@PathVariable("id") long id){
        System.out.println("delete");
        computerDaoService.deleteComputerById(id);
    }

    @GetMapping("/load")
    public List<Computer> loadComputers(){
        return computerDaoService.getComputerList();
    }

}
