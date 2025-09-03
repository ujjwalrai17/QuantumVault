package com.ujjwal.bankmanagement.serviceImplementation;

import com.ujjwal.bankmanagement.entity.Account;
import com.ujjwal.bankmanagement.entity.Customer;
import com.ujjwal.bankmanagement.repository.AccountRepository;
import com.ujjwal.bankmanagement.repository.CustomerRepository;
import com.ujjwal.bankmanagement.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Account createAccount(Account account, Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        account.setCustomer(customer);
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account deposit(String accountNumber, Double amount) {
        Account account = getAccountByNumber(accountNumber);
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    @Override
    public Account withdraw(String accountNumber, Double amount) {
        Account account = getAccountByNumber(accountNumber);

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }
        account.setBalance(account.getBalance() - amount);

        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String accountNumber) {
        Account account = getAccountByNumber(accountNumber);
        accountRepository.delete(account);
    }
}
