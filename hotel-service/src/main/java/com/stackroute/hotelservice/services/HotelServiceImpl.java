package com.stackroute.hotelservice.services;
import com.stackroute.hotelservice.exception.*;
import com.stackroute.hotelservice.model.Hotel;
import com.stackroute.hotelservice.model.Room;
import com.stackroute.hotelservice.repository.HotelRepository;
import com.stackroute.hotelservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository repository;
    @Autowired
    RoomRepository roomRepository ;
    @Override
    public Hotel addHotel(Hotel hotel) throws HotelIdAlreadyExistException {
        Hotel hotel1;
        Optional<Hotel> optionalHotel = repository.findById(hotel.getHotelId());
        if(optionalHotel.isPresent()){
            throw new HotelIdAlreadyExistException("Duplicate Hotel Id");
        }
        else{

            Optional<List<Room>> optionalRoomList = Optional.ofNullable(hotel.getRoomList());
            optionalRoomList.ifPresent(roomList ->
                    roomList.forEach(room -> roomRepository.save(room)));
            hotel1= repository.save(hotel);
        }

        return hotel1;
    }
    @Override
    public List<Hotel> viewAllHotels() {
        return repository.findAll();
    }

    @Override
    public boolean deleteHotelbyHotelId(String hotelId) throws HotelIdDoesNotExistException {

        Optional<Hotel> optionalHotel = repository.findById(hotelId);
        if(optionalHotel.isPresent()){
            repository.deleteById(hotelId);
            return true;
        }else
            throw new HotelIdDoesNotExistException("Hotel Id is not available in DB");
    }

    @Override
    public Hotel updateHotel(Hotel hotel) throws HotelIdDoesNotExistException {
        Optional<Hotel> optionalRoom = repository.findById(hotel.getHotelId());
        if(optionalRoom.isPresent()){
            return repository.save(hotel);
        }else
            throw new HotelIdDoesNotExistException("HotelId is not Available in DB");
    }

    @Override
    public Optional<Hotel> getHotelByHotelId(String hotelId) {
        return repository.findById(hotelId);
    }

    @Override
    public Hotel addRoom(String hotelId, Room room) throws HotelIdDoesNotExistException {
        Optional<Hotel> optionalHotel = repository.findById(hotelId);

        if (optionalHotel.isEmpty()) {
            throw new HotelIdDoesNotExistException("notFound");
        } else {
            Hotel hotel = optionalHotel.get();
            List<Room> existRoomList = hotel.getRoomList();

            if (existRoomList == null) {
                existRoomList = new ArrayList<>(); // Create a new list if it's null
            }

            existRoomList.add(room);
            hotel.setRoomList(existRoomList);
            Optional<List<Room>> optionalRoomList = Optional.ofNullable(hotel.getRoomList());
            optionalRoomList.ifPresent(roomList ->
                    roomList.forEach(rooms -> roomRepository.save(room)));
            return repository.save(hotel);
        }
    }

    @Override
    public List<Hotel> getHotelByLocation(String location) {
        return repository.findByLocation(location);
    }
    @Override
    public Hotel getHotelByName(String name) {
        return repository.findByHotelName(name);
    }

    @Override
    public boolean deleteRoom(String hotelId, String roomNo) throws HotelIdDoesNotExistException, RoomNoDoesNotExistException {
        Optional<Hotel> medicalShop = repository.findById(hotelId);
        if(medicalShop.isEmpty()){
            throw new HotelIdDoesNotExistException("Not Found");
        }
        else {
            Hotel hotel1 = medicalShop.get();
            List<Room> existHotel = hotel1.getRoomList();
            existHotel.removeIf((med) ->med.getRoomId().equals(roomNo));
            hotel1.setRoomList(existHotel);
            repository.save(hotel1);
            return true;
        }
    }
    @Override
    public List<Hotel> getHotelBasedOnCost(int price) {
        return repository.findByPriceGreaterThan(price);
    }


}
