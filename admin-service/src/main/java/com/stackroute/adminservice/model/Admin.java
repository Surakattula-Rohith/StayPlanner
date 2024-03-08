package com.stackroute.adminservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Admin {
    @Id
    int adminId;
    String aadhaarNo;
    String adminName;
    String adminEmail;
    String mblNo;
    String dob;
    String address;

    public Admin(int adminId, String aadhaarNo, String adminName, String adminEmail, String mblNo, String dob, String address) {
        this.adminId = adminId;
        this.aadhaarNo = aadhaarNo;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.mblNo = mblNo;
        this.dob = dob;
        this.address = address;
    }

    public Admin() {
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getMblNo() {
        return mblNo;
    }

    public void setMblNo(String mblNo) {
        this.mblNo = mblNo;
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
}
