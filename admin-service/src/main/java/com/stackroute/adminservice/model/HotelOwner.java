package com.stackroute.adminservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class HotelOwner {
    @Id
    String ownerId;
    String Email;
    String Name;
    String mobileNo;
    String referalCode;
    String addr;
    String DOB;
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
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }
}



