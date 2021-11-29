package com.project.full.ComputerShoping.service;

import com.project.full.ComputerShoping.model.Computer;
import com.project.full.ComputerShoping.repository.ComputerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerDaoService {

    private final ComputerRepository computerRepository;

    public ComputerDaoService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public void addComputer(Computer computer) {
        computerRepository.save(computer);
    }

    public List<Computer> getComputerList(){
        return computerRepository.findAll();
    }

}
