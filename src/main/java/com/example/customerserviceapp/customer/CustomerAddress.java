package com.example.customerserviceapp.customer;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CustomerAddress {
    private String routeNumber;
    private String streetName;
    private String apartmentNumber;
    private String city;
    private String state;
    private String zipCode;

    // With apartment number
    public CustomerAddress(String routeNumber, String streetName, String apartmentNumber, String city, String state, String zipCode) {
        this.routeNumber = routeNumber;
        this.streetName = streetName;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getZipCode() { return zipCode;    }

    public void setZipCode(String zipCode) { this.zipCode = zipCode;    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "routeNumber='" + routeNumber + '\n' +
                ", streetName='" + streetName + '\n' +
                ", apartmentNumber='" + apartmentNumber + '\n' +
                ", city='" + city + '\n' +
                ", state='" + state + '\n' +
                ", zipCode='" + zipCode + '\n' +
                '}';
    }
}
