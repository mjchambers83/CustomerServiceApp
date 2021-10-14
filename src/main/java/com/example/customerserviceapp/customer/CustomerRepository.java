package com.example.customerserviceapp.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
    //@Query("SELECT s FROM customer s WHERE s.email =?1")
    Optional<Customer> findByEmail(String email);
    Customer getCustomerById(long id);
}
