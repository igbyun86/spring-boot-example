package com.springboot.security;

import com.springboot.security.account.Account;
import com.springboot.security.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account ig = accountService.createAccount("ig", "1234");
        System.out.println(ig.getUsername() + " password: " + ig.getPassword());
    }
}
