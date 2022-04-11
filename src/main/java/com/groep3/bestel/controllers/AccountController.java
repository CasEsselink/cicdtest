package com.groep3.bestel.controllers;

import com.groep3.bestel.entities.Account;
import com.groep3.bestel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public @ResponseBody String addNewAccount(@RequestBody Account account) {
        accountService.addAccount(account);
        return "Saved";
    }

    @GetMapping("/accounts")
    public @ResponseBody Iterable<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}