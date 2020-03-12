package com.kata.banking;

import com.kata.banking.com.kata.banking.service.api.AccountService;
import com.kata.banking.com.kata.banking.service.impl.AccountServiceImpl;
import com.kata.banking.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceUnitTest {

    AccountService accountService;

    @BeforeEach
    public void createServices() {
        this.accountService = new AccountServiceImpl();
    }

    @Test
    public void testAccountCreationAndFind() {
        Account actual = new Account();
        String accountId = UUID.randomUUID().toString();
        actual.setId(accountId);
        accountService.createAccount(actual);
        Account filteredAccount = accountService.getAccountById(accountId);
        assertEquals(filteredAccount.getId(),actual.getId());
    }
}
