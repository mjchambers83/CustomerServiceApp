package com.example.customerserviceapp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller layer depends on Service layer
@RestController
@RequestMapping("/rest/users")
public class CustomerController {

    //private CustomerRepository customerRepository;
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    //@GetMapping("/all")
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomer();
    }

    @GetMapping("{id}")
    //http://localhost:port/rest/users/1
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long customerId) {
        return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }


    // POST
    @PostMapping
    public ResponseEntity registerNewCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
        return new ResponseEntity("Customer Sucessfully Added:\n" + customer.toString(), HttpStatus.OK);
    }



    //DELETE
    @DeleteMapping(path="{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable("customerId") Long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity("Customer " + customerId + " has been removed.", HttpStatus.OK);
    }

    // PUT
    @PutMapping(path = "{customerId}")
    public ResponseEntity updateCustomer(
            @PathVariable("customerId") Long customerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        customerService.updateCustomer(customerId, name, email);
        return new ResponseEntity("Customer " + customerId + " has been updated:\n" + name + " " + email, HttpStatus.OK);
    }
}
