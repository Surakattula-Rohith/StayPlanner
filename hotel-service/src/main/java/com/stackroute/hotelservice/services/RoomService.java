package com.stackroute.hotelservice.services;

import com.stackroute.hotelservice.exception.RoomNoAlreadyExistException;
import com.stackroute.hotelservice.exception.RoomNoDoesNotExistException;
import com.stackroute.hotelservice.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    public Room addRoom(Room room) throws RoomNoAlreadyExistException;
    public List<Room> viewAllRooms();
    //delete
    boolean deleteRoombyRoomNo(String roomNo) throws RoomNoDoesNotExistException;
    public Room updateRoom(Room room) throws RoomNoDoesNotExistException;
    //update
    public Optional<Room> getHotelRoomByRoomNo(String roomNo);
    List<Room> getRoomBasedOnCost(int price);

}
