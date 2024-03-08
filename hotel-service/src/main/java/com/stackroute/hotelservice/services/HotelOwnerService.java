package com.stackroute.hotelservice.services;

import com.stackroute.hotelservice.exception.HotelIdDoesNotExistException;
import com.stackroute.hotelservice.exception.HotelNameNotFoundException;
import com.stackroute.hotelservice.exception.HotelOwnerIdAlreadyExistException;
import com.stackroute.hotelservice.exception.HotelOwnerIdDoesNotExistException;
import com.stackroute.hotelservice.model.Hotel;
import com.stackroute.hotelservice.model.HotelOwner;

import java.util.List;
import java.util.Optional;

public interface HotelOwnerService {
    // add new Hotel Owner
    public HotelOwner addHotelOwner(HotelOwner hotelOwner) throws HotelOwnerIdAlreadyExistException;
    // getting all Hotel Owner
    public List<HotelOwner> viewAllHotelOwner();
    //delete Hotel Owner Using OwnerId
    boolean deleteHotelOwnerbyOwnerId(String ownerId) throws HotelOwnerIdDoesNotExistException;
    // update Owner Details
    public HotelOwner updateOwner(HotelOwner hotelOwner) throws HotelOwnerIdDoesNotExistException;
    // fetch Owner Details using ownerId
    public Optional<HotelOwner> getOwnerByOwnerId(String ownerId);
    // add new Hotel using ownerId
    HotelOwner addHotel(String ownerId, Hotel hotel) throws HotelOwnerIdDoesNotExistException;
//    List<HotelOwner> getHotelOwnerByAddr(String addr);
    boolean deleteHotel(String ownerId, String hotelId) throws HotelOwnerIdDoesNotExistException, HotelIdDoesNotExistException;
    public Hotel getHotelByName(String ownerId, String hotelName) throws HotelOwnerIdDoesNotExistException, HotelNameNotFoundException;
    public Hotel getHotelByAddress(String ownerId, String hotelAddress) throws HotelOwnerIdDoesNotExistException, HotelNameNotFoundException;
}
