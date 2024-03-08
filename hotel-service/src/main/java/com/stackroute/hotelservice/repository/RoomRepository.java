package com.stackroute.hotelservice.repository;

import com.stackroute.hotelservice.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends MongoRepository<Room,String> {

    List<Room> findByPriceGreaterThan(int price);

}
