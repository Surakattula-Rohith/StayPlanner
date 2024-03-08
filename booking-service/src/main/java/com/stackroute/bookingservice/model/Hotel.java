package com.stackroute.bookingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Hotel")
public class Hotel {
    // Hotel Model Properties
    @Id
    String hotelId;
    String hotelName;
    String hotelAddress;
    String location;
    String referalCode;
    String gstNumber;
    String availability;
    boolean acNonAc;
    String NearbyTransportation;
    boolean wifi;
    boolean maintanance;
    boolean restoRent;
    int price;
    List<Room> roomList;

    //getter and setter


    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getReferalCode() {
        return referalCode;
    }

    public void setReferalCode(String referalCode) {
        this.referalCode = referalCode;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public boolean isAcNonAc() {
        return acNonAc;
    }

    public void setAcNonAc(boolean acNonAc) {
        this.acNonAc = acNonAc;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isMaintanance() {
        return maintanance;
    }

    public void setMaintanance(boolean maintanance) {
        this.maintanance = maintanance;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getNearbyTransportation() {
        return NearbyTransportation;
    }

    public void setNearbyTransportation(String nearbyTransportation) {
        NearbyTransportation = nearbyTransportation;
    }

    public boolean isRestoRent() {
        return restoRent;
    }

    public void setRestoRent(boolean restoRent) {
        this.restoRent = restoRent;
    }



    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

