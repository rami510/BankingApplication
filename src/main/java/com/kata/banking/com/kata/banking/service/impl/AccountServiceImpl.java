package com.kata.banking.com.kata.banking.service.impl;

import com.kata.banking.com.kata.banking.service.api.AccountService;
import com.kata.banking.model.Account;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class AccountServiceImpl implements AccountService {
    private AccountServiceImpl() {
    }

    private static AccountService instance;

    public static AccountService getInstance() {
        if (isNull(instance))
            instance = new AccountServiceImpl();
        return instance;
    }

    // we should delegate data input output to a repository layer (no database is needed on our case we chose to make it simple)
    private List<Account> accountList = new ArrayList<Account>();

    @Override
    public void createAccount(Account account) {
        Account existingAccount = this.getAccountById(account.getId());
        if (isNull(existingAccount))
            this.accountList.add(account);
    }

    @Override
    public Account getAccountById(String accountId) {
        return this.accountList.stream().filter((a) -> a.getId().equals(accountId)).findFirst().orElse(null);
    }
}
