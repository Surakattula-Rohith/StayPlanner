package com.stackroute.reviewservice.controller;

import com.stackroute.reviewservice.exception.ReviewIdDoesNotExistException;
import com.stackroute.reviewservice.model.Review;
import com.stackroute.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/reviews")
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/addreviews")
    public ResponseEntity<Review> create(@RequestBody Review review) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.create(review));
    }

    @GetMapping("/getreviews")
    public ResponseEntity<List<Review>> getReviews() {
        return ResponseEntity.of(Optional.ofNullable(reviewService.getReviews()));
    }

    @DeleteMapping("/delete/{reviewid}")
    public ResponseEntity<?> deleteReview(@PathVariable("reviewid") String id) {
        try {
            boolean result = reviewService.deleteReviewbyId(id);
            return new ResponseEntity<String>("Review Record Deleted", HttpStatus.OK);
        } catch (ReviewIdDoesNotExistException e) {
            return new ResponseEntity<String>("Review Id Does exist in DB", HttpStatus.CONFLICT);
        } catch (NumberFormatException exception) {
            return new ResponseEntity<String>("Review Id always be a number", HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/review/{reviewId}")
    public ResponseEntity<?> updateNews(@PathVariable String reviewId, @RequestBody Review review) {
        review.setReviewId(reviewId);
        try {
            Review updatedReview = reviewService.updateReview(review);
            return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        } catch (ReviewIdDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
