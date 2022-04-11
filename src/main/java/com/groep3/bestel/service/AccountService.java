package com.groep3.bestel.service;

import com.groep3.bestel.entities.Account;
import com.groep3.bestel.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public void addAccount(Account account) {
        accountRepository.save(account);
    }
}
