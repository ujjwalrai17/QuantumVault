package com.ujjwal.bankmanagement.controller;

import com.ujjwal.bankmanagement.entity.Account;
import com.ujjwal.bankmanagement.entity.Transaction;
import com.ujjwal.bankmanagement.service.AccountService;
import com.ujjwal.bankmanagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;


    @PostMapping("/{customerId}")
    public ResponseEntity<Account> createAccount(
            @RequestBody Account account,
            @PathVariable Long customerId) {
        return ResponseEntity.ok(accountService.createAccount(account, customerId));
    }


    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.getAccountByNumber(accountNumber));
    }

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<Transaction> deposit(
            @PathVariable String accountNumber,
            @RequestParam Double amount) {
        return ResponseEntity.ok(transactionService.deposit(accountNumber, amount));
    }


    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<Transaction> withdraw(
            @PathVariable String accountNumber,
            @RequestParam Double amount) {
        return ResponseEntity.ok(transactionService.withdraw(accountNumber, amount));
    }


    @GetMapping("/{accountNumber}/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable String accountNumber) {
        return ResponseEntity.ok(transactionService.getTransactionsByAccount(accountNumber));
    }
}
