package com.stackroute.reviewservice.service;

import com.stackroute.reviewservice.exception.ReviewIdDoesNotExistException;
import com.stackroute.reviewservice.model.Review;
import com.stackroute.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReviewServiceImp implements ReviewService {

    @Autowired
    private ReviewRepository repository;


    @Override
    public Review create(Review review) {

        return repository.save(review);

    }

    @Override
    public List<Review> getReviews(){
        return repository.findAll();
    }

    @Override
    public boolean deleteReviewbyId(String reviewId) throws ReviewIdDoesNotExistException {

        Optional<Review> optionalCustomer = repository.findById(reviewId);
        if(optionalCustomer.isPresent()){
            repository.deleteById(reviewId);
            return true;
        }else
            throw new ReviewIdDoesNotExistException("Review Id is not available in DB");
    }

    @Override
    public Review updateReview(Review review) throws ReviewIdDoesNotExistException {
        if (!repository.existsById(review.getReviewId())){
            throw new ReviewIdDoesNotExistException("Review with ID " + review.getReviewId() + " not found.");
        }
        return repository.save(review);
    }



}
