package com.stackroute.customerservice.service;

import com.stackroute.customerservice.model.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("Review")
public interface ReviewFeign {

    @GetMapping("reviews/getreviews")
    public List<Review> getAllReviews();

    @PutMapping("reviews/review/{reviewId}")
    public Review updateReviewById(@PathVariable String reviewId, @RequestBody Review review);
    //Review updateReviewById(String reviewId);
}

