package com.project.full.ComputerShoping.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    private LoginController loginController;

    @BeforeEach
    void setUp() {
        loginController = new LoginController();
    }

    @Test
    void canGetLoginPage() {
        // given
        String text = "login";

        // when

        String result = loginController.getLoginPage();

        // then
        assertThat(result).isEqualTo(text);
    }
}