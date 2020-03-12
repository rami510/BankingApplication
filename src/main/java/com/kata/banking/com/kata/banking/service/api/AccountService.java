package com.kata.banking.com.kata.banking.service.api;

import com.kata.banking.model.Account;


public interface AccountService {
    public void createAccount(Account account);

    public Account getAccountById(String id);
}
