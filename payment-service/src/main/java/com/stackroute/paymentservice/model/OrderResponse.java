package com.stackroute.paymentservice.model;

public class OrderResponse {
    String secretId;
    String secretKey;
    String razorpayOrderId;
    String applicationFee;

    String psName;
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getRazorpayOrderId() {
        return razorpayOrderId;
    }

    public void setRazorpayOrderId(String razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    public String getApplicationFee() {
        return applicationFee;
    }

    public void setApplicationFee(String applicationFee) {
        this.applicationFee = applicationFee;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }
}
