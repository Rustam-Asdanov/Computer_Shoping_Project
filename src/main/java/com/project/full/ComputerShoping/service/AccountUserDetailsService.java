package com.project.full.ComputerShoping.service;

import com.project.full.ComputerShoping.model.Account;
import com.project.full.ComputerShoping.model.AccountUserDetails;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import static com.project.full.ComputerShoping.security.ApplicationRole.GUEST;

@Service
public class AccountUserDetailsService implements UserDetailsService {

    private final AccountDaoService accountDaoService;
    private final PasswordEncoder passwordEncoder;

    public AccountUserDetailsService(AccountDaoService accountDaoService, PasswordEncoder passwordEncoder) {
        this.accountDaoService = accountDaoService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return selectAccountByUsername(username);
    }

    private AccountUserDetails selectAccountByUsername(String username){

        Account account = accountDaoService.getAccountByUsername(username);

        AccountUserDetails accountUserDetails = new AccountUserDetails(
                account.getUsername(),
                passwordEncoder.encode(account.getPassword()),
                GUEST.getSimpleGrantedAuthority(),
                true,
                true,
                true,
                true
        );

        return accountUserDetails;
    }
}
