package com.stackroute.hotelservice.services;
import com.stackroute.hotelservice.exception.RoomNoAlreadyExistException;
import com.stackroute.hotelservice.exception.RoomNoDoesNotExistException;
import com.stackroute.hotelservice.model.Room;
import com.stackroute.hotelservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository repository;
    @Override
    public Room addRoom(Room room) throws RoomNoAlreadyExistException {
        Room room1;
        Optional<Room> optionalRoom = repository.findById(room.getRoomId());
        if(optionalRoom.isPresent()){
            throw new RoomNoAlreadyExistException("Duplicate Room No");
        }
        else
            room1 = repository.save(room);
        return room1;
    }
    @Override
    public List<Room> viewAllRooms() {
        return repository.findAll();
    }

    @Override
    public boolean deleteRoombyRoomNo(String roomNo) throws RoomNoDoesNotExistException {

        Optional<Room> optionalRoom = repository.findById(roomNo);
        if(optionalRoom.isPresent()){
            repository.deleteById(roomNo);
            return true;
        }else
            throw new RoomNoDoesNotExistException("Room No is not available in DB");
    }

    @Override
    public Room updateRoom(Room room) throws RoomNoDoesNotExistException {
        Optional<Room> optionalRoom = repository.findById(room.getRoomId());
        if(optionalRoom.isPresent()){
            return repository.save(room);
        }else
            throw new RoomNoDoesNotExistException("Room No is not Available in DB");
    }

    @Override
    public Optional<Room> getHotelRoomByRoomNo(String roomNo) {
        return repository.findById(roomNo);
    }

    @Override
    public List<Room> getRoomBasedOnCost(int price) {
        return repository.findByPriceGreaterThan(price);
    }

}
