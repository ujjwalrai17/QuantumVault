package com.ujjwal.bankmanagement.service;

import com.ujjwal.bankmanagement.entity.Customer;

import java.util.List;

public interface CustomerService {

        Customer createCustomer(Customer customer);

        List<Customer> getAllCustomers();

        Customer getCustomerById(Long id);

        Customer getCustomerByAccountNumber(String accountNumber);

        Customer updateCustomer(Long id, Customer updatedCustomer);

        void deleteCustomer(Long id);


}
