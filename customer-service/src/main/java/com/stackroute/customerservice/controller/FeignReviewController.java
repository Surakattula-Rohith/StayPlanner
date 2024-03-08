package com.stackroute.customerservice.controller;

import com.stackroute.customerservice.model.Review;
import com.stackroute.customerservice.service.ReviewFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FeignReviewController {
    @Autowired
    ReviewFeign reviewFeign;
    @GetMapping("review/data")

    public ResponseEntity<List> getReviewDesc(){
        List<Review> getReview=reviewFeign.getAllReviews();
        return new ResponseEntity<>(getReview, HttpStatus.OK);
    }
    @PutMapping("updateReview/{reviewId}")
    public ResponseEntity<Review> updateReviewById(@PathVariable String reviewId, @RequestBody Review review) {
//        review.setReviewId(reviewId);
//        Review updatedReview = reviewFeign.updateReviewById(reviewId);
//        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        return new ResponseEntity<>(reviewFeign.updateReviewById(reviewId,review),HttpStatus.OK);
    }
}

