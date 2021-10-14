package com.example.customerserviceapp.customer;

import org.apache.tomcat.jni.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Users
@Document
public class Customer {

    @Id
    private Long id;
    private String name;
    private String email;
    private CustomerAddress customerAddress;

    public Customer() {
        //Default
    }

    public Customer(Long id, String name, String email, CustomerAddress customerAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.customerAddress = customerAddress;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\n' +
                ", email='" + email + '\n' +
                ", customerAddress=" + customerAddress.toString() + '\n' +
                '}';
    }
}
