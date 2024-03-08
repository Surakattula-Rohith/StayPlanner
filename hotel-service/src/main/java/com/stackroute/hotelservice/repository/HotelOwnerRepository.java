package com.stackroute.hotelservice.repository;

import com.stackroute.hotelservice.model.HotelOwner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelOwnerRepository extends MongoRepository<HotelOwner,String> {
//    List<HotelOwner> findByAddr(String addr);

}
