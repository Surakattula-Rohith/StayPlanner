package com.stackroute.hotelservice.repository;

import com.stackroute.hotelservice.model.Hotel;
import com.stackroute.hotelservice.model.HotelOwner;
import com.stackroute.hotelservice.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String> {
    Hotel findByHotelName(String med);
    Hotel findByHotelAddress(String med);
    List<Hotel> findByLocation(String location);
    List<Hotel> findByPriceGreaterThan(int price);

}
