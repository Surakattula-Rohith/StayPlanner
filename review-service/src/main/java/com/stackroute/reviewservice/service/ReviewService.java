package com.stackroute.reviewservice.service;

import com.stackroute.reviewservice.exception.ReviewIdDoesNotExistException;
import com.stackroute.reviewservice.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ReviewService {

    Review create( Review review );
    List<Review> getReviews();
    boolean deleteReviewbyId(String reviewId) throws ReviewIdDoesNotExistException;

    Review updateReview(Review review) throws ReviewIdDoesNotExistException;
}
