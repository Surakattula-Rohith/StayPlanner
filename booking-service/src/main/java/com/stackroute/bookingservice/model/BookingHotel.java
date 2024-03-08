package com.stackroute.bookingservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;


@Document
public class BookingHotel {

    @Id
    String bookingId ;
    Customer customer ;
    Hotel hotel ;

    Date startDate ;
    Date endDate ;
    String coupon ;

    public BookingHotel() {
    }

    public BookingHotel(String bookingId, Customer customer, Hotel hotel,  Date startDate, Date endDate, String coupon) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.hotel = hotel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coupon = coupon;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }



    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
}
