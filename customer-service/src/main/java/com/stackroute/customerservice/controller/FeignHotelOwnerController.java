package com.stackroute.customerservice.controller;

import com.stackroute.customerservice.model.Hotel;
import com.stackroute.customerservice.service.HotelOwnerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FeignHotelOwnerController {
    @Autowired
    HotelOwnerFeign hotelOwnerFeign;
//    @GetMapping("hotel/data")
//    public ResponseEntity<List> getAvailability(){
//        List<Hotel> getAllAvailableRooms=hotelOwnerFeign.getAvailability();
//        return new ResponseEntity<>(getAllAvailableRooms, HttpStatus.OK);
//    }
//    @GetMapping("review/data")
//    public ResponseEntity<List> getReviewDesc(){
//        List<Review> getReview=customerFeign.getAllReviews();
//        return new ResponseEntity<>(getReview,HttpStatus.OK);
//    }
//    @PutMapping("updatedReview/{reviewId}")
//    public ResponseEntity<Review> update(@RequestBody Review review){
//        //List<Review> updatedReview=customerFeign.update();
//        return new ResponseEntity<Review>(customerFeign.update(review),HttpStatus.OK);
//    }

}
