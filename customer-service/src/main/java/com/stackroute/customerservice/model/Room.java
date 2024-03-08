package com.stackroute.customerservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Room")
public class Room {
    @Id
    String roomId;
    String bedType;
   // int price;
    boolean acNonAc;
    boolean wifi;
    boolean maintanance;

    public Room(String roomId, String bedType, boolean acNonAc, boolean wifi, boolean maintanance) {
        this.roomId = roomId;
        this.bedType = bedType;
        //this.price = price;
        this.acNonAc = acNonAc;
        this.wifi = wifi;
        this.maintanance = maintanance;
    }

    public Room() {
    }

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

//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }

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
}
