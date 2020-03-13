package com.kata.banking;

import com.kata.banking.com.kata.banking.service.api.AccountService;
import com.kata.banking.com.kata.banking.service.impl.AccountServiceImpl;
import com.kata.banking.model.Account;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static junit.framework.TestCase.assertEquals;

public class AccountServiceUnitTest {

    AccountService accountService;

    @Before
    public void createServices() {
        this.accountService = AccountServiceImpl.getInstance();
    }

    @Test
    public void testAccountCreationAndFind() {
        Account actual = new Account();
        String accountId = UUID.randomUUID().toString();
        actual.setId(accountId);
        accountService.createAccount(actual);
        Account filteredAccount = accountService.getAccountById(accountId);
        assertEquals(filteredAccount.getId(), actual.getId());
    }
}
