Bank account kata

Think of your personal bank account experience. When in doubt, go for the simplest solution

Requirements

Deposit and Withdrawal
Account statement (date, amount, balance)
Statement printing
The expected result is a service API, and its underlying implementation, that meets the expressed needs.
Nothing more, especially no UI, no persistence.

User Stories

US 1:

In order to save money
As a bank client
I want to make a deposit in my account

US 2:

In order to retrieve some or all of my savings
As a bank client
I want to make a withdrawal from my account

US 3:

In order to check my operations
As a bank client
I want to see the history (operation, date, amount, balance) of my operat

us 1 / 2 : OperationServiceUnitTest
us 3 : StatementServiceUnitTest
-------------------------------------------------------

*testing results* :

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.kata.banking.AccountServiceUnitTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.459 sec
Running com.kata.banking.ClientServiceUnitTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec
Running com.kata.banking.OperationServiceUnitTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.045 sec
Running com.kata.banking.StatementServiceUnitTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.017 sec

Results :

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

