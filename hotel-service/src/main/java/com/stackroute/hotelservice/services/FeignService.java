package com.stackroute.hotelservice.services;

import com.stackroute.hotelservice.model.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient("Review")
public interface FeignService {

    @GetMapping("reviews/getreviews")
    public List<Review> getAllReview();
    @PostMapping("api/v1/addrating")
    public Review saverating(@RequestBody Review patient);

    @GetMapping("api/v1/viewbyname/{name}")
    public List<Review> getByName(@PathVariable String name);

    @GetMapping("reviews/getreviews/{hotelid}")
    public List<Review> getAllReviewbyhotelId();

}
