package com.project.full.ComputerShoping.service;

import com.project.full.ComputerShoping.repository.ComputerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ComputerDaoServiceTest {

    @Autowired
    private ComputerRepository computerRepository;
    private ComputerDaoService computerDaoService;


    @BeforeEach
    void setUp() {
        computerDaoService = new ComputerDaoService(computerRepository);
    }

    @Test
    void addComputer() {
    }

    @Test
    void addComputerImage() {
    }

    @Test
    void getComputerList() {
    }

    @Test
    void canCheckImageName() {
        // given
        String name = "capture";
        // when
        int number = computerDaoService.checkImageName(name);

        // then
        assertThat(number).isEqualTo(3);

    }
}