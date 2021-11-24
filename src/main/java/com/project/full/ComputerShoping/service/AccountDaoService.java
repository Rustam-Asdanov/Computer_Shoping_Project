package com.project.full.ComputerShoping.service;

import com.project.full.ComputerShoping.model.Account;
import com.project.full.ComputerShoping.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountDaoService {

    private final AccountRepository accountRepository;

    public AccountDaoService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createNewAccount(Account account) {
        accountRepository.save(account);
    }

    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
