package com.ujjwal.bankmanagement.service;

import com.ujjwal.bankmanagement.entity.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account, Long customerId);

    Account getAccountByNumber(String accountNumber);

    List<Account> getAllAccounts();

    Account deposit(String accountNumber, Double amount);

    Account withdraw(String accountNumber, Double amount);

    void deleteAccount(String accountNumber);

}
