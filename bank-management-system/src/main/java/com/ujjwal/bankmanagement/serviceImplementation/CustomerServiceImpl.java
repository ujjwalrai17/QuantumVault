package com.ujjwal.bankmanagement.serviceImplementation;

import com.ujjwal.bankmanagement.entity.Customer;
import com.ujjwal.bankmanagement.repository.CustomerRepository;
import com.ujjwal.bankmanagement.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer)
    {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id)
    {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public Customer getCustomerByAccountNumber(String accountNumber) {
        return customerRepository.findByAccounts_AccountNumber(accountNumber);
    }



    @Override
    public Customer updateCustomer(Long id, Customer updatedCustomer)
    {
        Customer existingCustomer = getCustomerById(id);
        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPhone(updatedCustomer.getPhone());
        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(Long id)
    {
        customerRepository.deleteById(id);
    }
}
