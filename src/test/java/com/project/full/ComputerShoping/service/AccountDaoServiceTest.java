package com.project.full.ComputerShoping.service;

import com.project.full.ComputerShoping.model.Account;
import com.project.full.ComputerShoping.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

class AccountDaoServiceTest {

    @Mock
    private AccountRepository accountRepository;
    private AutoCloseable autoCloseable;
    private AccountDaoService accountDaoService;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        accountDaoService = new AccountDaoService(accountRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canCreateNewAccount() {
        // given
        Account account = new Account(
                "test",
                "test",
                "test",
                "test",
                "test"
        );

        ArgumentCaptor<Account> accountArgumentCaptor =
                ArgumentCaptor.forClass(Account.class);

        // when
        accountDaoService.createNewAccount(account);

        // then
        verify(accountRepository).save(accountArgumentCaptor.capture());
        Account resultAccount = accountArgumentCaptor.getValue();
        assertThat(resultAccount).isEqualTo(account);
    }

    @Test
    void canGetAccountByUsername() {


    }
}