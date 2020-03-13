package com.kata.banking;

import com.kata.banking.com.kata.banking.service.api.OperationService;
import com.kata.banking.com.kata.banking.service.impl.OperationServiceImpl;
import com.kata.banking.model.Account;
import com.kata.banking.model.Operation;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class OperationServiceUnitTest {

    OperationService operationService;

    @Before
    public void createServices() {
        this.operationService = OperationServiceImpl.getInstance();
    }

    private Account setupAccount() {
        Account account = new Account();
        String accountId = UUID.randomUUID().toString();
        account.setId(accountId);
        return account;
    }

    @Test
    public void testWithdrawOperation() {
        //GIVEN
        Account account = setupAccount();
        BigDecimal withdrawelAmount=new BigDecimal(200);
        //WHEN
        operationService.withdraw(account,withdrawelAmount);
        //THEN
        assertEquals(account.getBalance(), new BigDecimal(-200));
    }


    @Test
    public void testDepositOperation() {
        //GIVEN
        Account account = setupAccount();
        BigDecimal depositAmount=new BigDecimal(200);
        //WHEN
        operationService.deposit(account,depositAmount);
        //THEN
        assertEquals(account.getBalance(), new BigDecimal(200));
    }

    @Test
    public void testGetAccountOperationHistory() {
        //GIVEN
        Account account = setupAccount();
        //WHEN
        operationService.deposit(account,new BigDecimal(500));
        operationService.deposit(account,new BigDecimal(1000));
        operationService.deposit(account,new BigDecimal(100));
        operationService.withdraw(account,new BigDecimal(300));
        operationService.deposit(account,new BigDecimal(700));
        List<Operation> operationList=operationService.getAccountOperationHistory(account.getId());

        //THEN

        assertEquals(operationList.size(),5);
        assertEquals(operationList.get(0).getAmount(),new BigDecimal(500));
        assertEquals(operationList.get(1).getAmount(),new BigDecimal(1000));
        assertEquals(operationList.get(2).getAmount(),new BigDecimal(100));
        assertEquals(operationList.get(3).getAmount(),new BigDecimal(300));
        assertEquals(operationList.get(4).getAmount(),new BigDecimal(700));

        assertEquals(operationList.get(0).getBalance(),new BigDecimal(500));
        assertEquals(operationList.get(1).getBalance(),new BigDecimal(1500));
        assertEquals(operationList.get(2).getBalance(),new BigDecimal(1600));
        assertEquals(operationList.get(3).getBalance(),new BigDecimal(1300));
        assertEquals(operationList.get(4).getBalance(),new BigDecimal(2000));

    }

}
