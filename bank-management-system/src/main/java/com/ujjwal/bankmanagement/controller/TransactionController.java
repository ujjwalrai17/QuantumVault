package com.ujjwal.bankmanagement.controller;

import com.ujjwal.bankmanagement.entity.Transaction;
import com.ujjwal.bankmanagement.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //  Deposit
    @PostMapping("/deposit/{accountNumber}")
    public ResponseEntity<Transaction> deposit(
            @PathVariable String accountNumber,
            @RequestParam Double amount) {
        return ResponseEntity.ok(transactionService.deposit(accountNumber, amount));
    }

    //  Withdraw
    @PostMapping("/withdraw/{accountNumber}")
    public ResponseEntity<Transaction> withdraw(
            @PathVariable String accountNumber,
            @RequestParam Double amount) {
        return ResponseEntity.ok(transactionService.withdraw(accountNumber, amount));
    }

    //  Transfer
    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transfer(
            @RequestParam String fromAccount,
            @RequestParam String toAccount,
            @RequestParam Double amount) {
        return ResponseEntity.ok(transactionService.transfer(fromAccount, toAccount, amount));
    }

    //  Get all transactions for an account
    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<Transaction>> getTransactionsByAccount(
            @PathVariable String accountNumber) {
        return ResponseEntity.ok(transactionService.getTransactionsByAccount(accountNumber));
    }
}
