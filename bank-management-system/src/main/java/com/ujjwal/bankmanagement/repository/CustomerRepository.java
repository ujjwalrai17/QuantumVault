package com.ujjwal.bankmanagement.repository;

import com.ujjwal.bankmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


    Customer findByAccounts_AccountNumber(String accountNumber);

}
