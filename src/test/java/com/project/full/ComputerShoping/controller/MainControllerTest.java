package com.project.full.ComputerShoping.controller;

import com.project.full.ComputerShoping.model.Account;
import com.project.full.ComputerShoping.service.AccountDaoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class MainControllerTest {

    @Mock
    private AccountDaoService accountDaoService;

    @Mock
    private Model model;

    private AutoCloseable autoCloseable;
    private MainController mainController;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        mainController = new MainController(accountDaoService);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetMainPage() {
        // given
        String text = "main";

        // when
        String result = mainController.getMainPage();

        // then
        assertThat(result).isEqualTo(text);
    }

    @Test
    void canGetRegistrationPage() {

        // given
        String text = "registration";

        // when
        String result = mainController.getRegistrationPage(model);

        // then
        assertThat(result).isEqualTo(text);

    }

    @Test
    void canCreateAccount() {
        // given
        String text = "redirect:/login";
        Account testAccount = new Account(
                "test",
                "test",
                "test",
                "test",
                "test");

        ArgumentCaptor<Account> argumentCaptor =
                ArgumentCaptor.forClass(Account.class);

        // when
        String result = mainController.createAccount(testAccount);
        verify(accountDaoService).createNewAccount(argumentCaptor.capture());

        // then
        assertThat(result).isEqualTo(text);
        Account resultAccount = argumentCaptor.getValue();
        assertThat(resultAccount).isEqualTo(testAccount);
    }
}