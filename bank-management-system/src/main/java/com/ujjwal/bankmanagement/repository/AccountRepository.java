package com.ujjwal.bankmanagement.repository;

import com.ujjwal.bankmanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account ,Long> {
    Optional<Account> findByAccountNumber(String accountNumber);
}
