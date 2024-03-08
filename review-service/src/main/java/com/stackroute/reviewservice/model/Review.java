package com.stackroute.reviewservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Review {

    public String customerId;
    public String hotelId;
    @Id
    public String reviewId;
    public String reviewDesc;

    public int rating;
    public int maintenance;
    public int wifi;
    public int affordability;

    public Review(String customerId, String hotelId, String reviewId, String reviewDesc, int rating, int maintenance, int wifi, int affordability) {
        this.customerId = customerId;
        this.hotelId = hotelId;
        this.reviewId = reviewId;
        this.reviewDesc = reviewDesc;
        this.rating = rating;
        this.maintenance = maintenance;
        this.wifi = wifi;
        this.affordability = affordability;
    }

    public Review() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public int getAffordability() {
        return affordability;
    }

    public void setAffordability(int affordability) {
        this.affordability = affordability;
    }
}
