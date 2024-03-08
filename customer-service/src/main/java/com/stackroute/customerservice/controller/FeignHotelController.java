package com.stackroute.customerservice.controller;

import com.stackroute.customerservice.model.Hotel;
import com.stackroute.customerservice.model.Room;
import com.stackroute.customerservice.service.HotelFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FeignHotelController {
    @Autowired
    HotelFeign hotelFeign;

    @GetMapping("customer/getAllHotels")
    public ResponseEntity<List> getAllHotels() {
        List<Hotel> getHotels = hotelFeign.viewAllHotels();
        return new ResponseEntity<>(getHotels, HttpStatus.OK);
    }

    @GetMapping("customer/getByHotellocation/{location}")
    public ResponseEntity<?> viewByLocation(@PathVariable String location) {
        List<Hotel> hotels = hotelFeign.viewByLocation(location);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/getHotelByName/{name}")
    public ResponseEntity<?> getHotelByName(@PathVariable String name) {
        Hotel hotel = hotelFeign.getHotelByName(name);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }
    @GetMapping("hotel/getHotelByPrice/{maxprice}")
    public ResponseEntity<?> getHotelBasedOnCost(@PathVariable int maxprice){
        List<Hotel> hotelList = hotelFeign.getHotelBasedOnCost(maxprice);
        return new ResponseEntity<List>(hotelList,HttpStatus.OK);
    }
}