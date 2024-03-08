package com.stackroute.hotelservice.services;



import com.stackroute.hotelservice.exception.*;
import com.stackroute.hotelservice.model.Hotel;
import com.stackroute.hotelservice.model.HotelOwner;
import com.stackroute.hotelservice.model.Room;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    // adding new Hotel
    public Hotel addHotel(Hotel hotel) throws HotelIdAlreadyExistException;
    // fetch the all hotel
    public List<Hotel> viewAllHotels();
    //delete the Hotel using HotelId
    boolean deleteHotelbyHotelId(String hotelId) throws HotelIdDoesNotExistException;
    // update the hotel data
    public Hotel updateHotel(Hotel hotel) throws HotelIdDoesNotExistException;
    // getting the hotel data using hotelId
    public Optional<Hotel> getHotelByHotelId(String hotelId);
    Hotel addRoom(String hotelId, Room room) throws HotelIdDoesNotExistException;
    List<Hotel> getHotelByLocation(String location);
    Hotel getHotelByName(String name);
    boolean deleteRoom(String hotelId, String roomNo) throws HotelIdDoesNotExistException, RoomNoDoesNotExistException;
    List<Hotel> getHotelBasedOnCost(int price);


}
