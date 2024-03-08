package com.stackroute.customerservice.service;

import com.stackroute.customerservice.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("hotelOwner")
public interface HotelOwnerFeign {
//    @GetMapping("hotelOwner/viewallhotelowner")
//    public List<Hotel> getAvailability();

//    @GetMapping("/reviews/getreviews")
//    public List<Review> getAllReviews();
//
//    @GetMapping("/reviews/review/{reviewId}")
//    public Review update(@RequestBody Review review);
}
