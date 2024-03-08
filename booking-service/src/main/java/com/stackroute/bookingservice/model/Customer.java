package com.stackroute.bookingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Customer {
//customerId is taken as primary Key
    @Id
    private  int customerId;
    private String aadhar;
    private String name;
    private String email;
    private String phoneNo;
    private String dob;
    private String address;
//    private List<String> bookedHotels;

//    public int getNumberOfBookedHotels() {
//        return bookedHotels.size()
//  }

//    public List<String> getBookedHotels() {
//        return bookedHotels;
//    }
//
//    public void setBookedHotels(List<String> bookedHotels) {
//        this.bookedHotels = bookedHotels;
//    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public String getBookedHotels() {
//        return bookedHotels;
//    }
//
//    public void setBookedHotels(String bookedHotels) {
//        this.bookedHotels = bookedHotels;
//    }
}
