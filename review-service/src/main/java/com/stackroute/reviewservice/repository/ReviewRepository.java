package com.stackroute.reviewservice.repository;

import com.stackroute.reviewservice.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review,String> {
}
