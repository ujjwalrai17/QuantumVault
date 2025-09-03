package com.ujjwal.bankmanagement.service;

import com.ujjwal.bankmanagement.entity.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction deposit(String accountNumber, Double amount);

    Transaction withdraw(String accountNumber, Double amount);

    Transaction transfer(String fromAccount, String toAccount, Double amount);

    List<Transaction> getTransactionsByAccount(String accountNumber);
}
