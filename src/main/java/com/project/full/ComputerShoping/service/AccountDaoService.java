package com.project.full.ComputerShoping.service;

import com.project.full.ComputerShoping.model.Account;
import com.project.full.ComputerShoping.repository.AccountRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Account account = accountRepository.findByUsername(username);
        return account;
    }

    public Account getCurrentUserAccount() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return accountRepository.findByUsername(auth.getName());
    }
}
