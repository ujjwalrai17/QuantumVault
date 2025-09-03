package com.ujjwal.bankmanagement.controller;

import com.ujjwal.bankmanagement.entity.Customer;
import com.ujjwal.bankmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }


    @GetMapping("/{accountNumber}")
    public ResponseEntity<Customer> getCustomerByAccountNumber(@PathVariable String accountNumber) {
        return ResponseEntity.ok(customerService.getCustomerByAccountNumber(accountNumber));
    }



    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long accountNumber) {
        customerService.deleteCustomer(accountNumber);
        return ResponseEntity.ok("Customer and associated account deleted successfully.");
    }


    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable Long customerId,
            @RequestBody Customer customerDetails) {
        Customer updatedCustomer = customerService.updateCustomer(customerId, customerDetails);
        return ResponseEntity.ok(updatedCustomer);
    }

}
