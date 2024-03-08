package com.stackroute.hotelservice.model;

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
    String acNonAc;
    String NearbyTransportation;
    String wifi;
    String maintanance;
    String restoRent;
    int price;
    List<Room> roomList;

    byte [] hotelImage;

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

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getAcNonAc() {
        return acNonAc;
    }

    public void setAcNonAc(String acNonAc) {
        this.acNonAc = acNonAc;
    }

    public String getNearbyTransportation() {
        return NearbyTransportation;
    }

    public void setNearbyTransportation(String nearbyTransportation) {
        NearbyTransportation = nearbyTransportation;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getMaintanance() {
        return maintanance;
    }

    public void setMaintanance(String maintanance) {
        this.maintanance = maintanance;
    }

    public String getRestoRent() {
        return restoRent;
    }

    public void setRestoRent(String restoRent) {
        this.restoRent = restoRent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public byte[] getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(byte[] hotelImage) {
        this.hotelImage = hotelImage;
    }
}

