package com.stackroute.bookingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "HotelOwner")
public class HotelOwner {
    // Hotel Owner Properties
    @Id
    String ownerId;
    String email;
    String name;
    String mobileNo;
    String referalCode;
    String addr;
    String dob;
    List<Hotel> hotelList;

    boolean aprovedbyadmin ;
    public boolean isAprovedbyadmin() {
        return aprovedbyadmin;
    }

    public void setAprovedbyadmin(boolean aprovedbyadmin) {
        this.aprovedbyadmin = aprovedbyadmin;
    }

    // getter and setter


    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getReferalCode() {
        return referalCode;
    }

    public void setReferalCode(String referalCode) {
        this.referalCode = referalCode;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }
}
