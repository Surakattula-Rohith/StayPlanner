package com.stackroute.bookingservice.repository;


import com.stackroute.bookingservice.model.BookingHotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<BookingHotel,String> {
}
