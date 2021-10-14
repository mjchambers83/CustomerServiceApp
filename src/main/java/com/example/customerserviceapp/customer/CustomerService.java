package com.example.customerserviceapp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

//@Service tells the program that this is a Bean/Service class
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Returns all customers
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    //Add new customer
    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findByEmail(customer.getEmail());
        if(customerOptional.isPresent()) {
            throw new IllegalStateException("ERROR: Email already exists");
        }
        customerRepository.save(customer);
    }

    //Removes a customer
    public void deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if(!exists) {
            throw new IllegalStateException("ERROR: Customer ID: " + customerId + " does not exist.\nPlease try again.");
        }
        customerRepository.deleteById(customerId);
    }

    //@Transactional means you don't have to implement JPL Query
    // http://localhost:7747/rest/users/1?name=Rufus&email=rufus@bill.com

    @Transactional
    public void updateCustomer(Long customerId, String name, String email) {

        // Checks if customer exists with that ID
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new IllegalStateException(
                "ERROR: Customer ID: " + customerId + " does not exit."));

        // Checks if the name is not null, the name length is greater than zero
        // and the name is not the same as the current one
        if(name != null && name.length() > 0 && !Objects.equals(customer.getName(), name)) {
            customer.setName(name);
        }

        // Checks if the email is not null, the email length is greater than zero
        // and the email is not the same as the current one
        Optional<Customer> customerOptional = customerRepository.findByEmail(email);
        if(email != null && email.length() > 0 && !Objects.equals(customer.getEmail(), email)) {
            if(customerOptional.isPresent()) {
                throw new IllegalStateException("ERROR: Email: " + email + " is already taken or the email does not match requirements.");
            }
        }
        customer.setEmail(email);
        customerRepository.save(customer);
    }

    // Get customer by ID
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("ERROR: Customer ID " + id + " not found."));
    }
}
