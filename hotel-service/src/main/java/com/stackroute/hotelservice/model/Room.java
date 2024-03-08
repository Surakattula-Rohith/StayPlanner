package com.stackroute.hotelservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//@Getter
//@Setter
@Document(collection = "Room")
public class Room {
    @Id
    String roomId;
    String bedType;
    int price;
    String acNonAc;
    String wifi;
    String maintanance;
    byte[] roomImage;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAcNonAc() {
        return acNonAc;
    }

    public void setAcNonAc(String acNonAc) {
        this.acNonAc = acNonAc;
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

    public byte[] getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(byte[] roomImage) {
        this.roomImage = roomImage;
    }
}

