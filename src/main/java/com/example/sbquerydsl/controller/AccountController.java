package com.example.sbquerydsl.controller;


import com.example.sbquerydsl.jooq.account.persistent.AccountEntity;
import com.example.sbquerydsl.jooq.account.service.AccountService;
import com.example.sbquerydsl.jooq.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class AccountController {


    @Autowired
    private AccountService accountService;

    @PostMapping("/account/new")
    public AccountEntity saveAccount( @RequestBody Account account) {
        return accountService.save(account);
    }

    @GetMapping("/account/{name}")
    public AccountEntity findAccount(@PathVariable String name) {
        return accountService.findOne(name);
    }
}
