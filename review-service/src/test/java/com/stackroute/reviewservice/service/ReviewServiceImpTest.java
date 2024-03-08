package com.stackroute.reviewservice.service;

import com.stackroute.reviewservice.model.Review;
import com.stackroute.reviewservice.repository.ReviewRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewServiceImpTest {

    @Autowired
    ReviewRepository repository;
    @Autowired
    ReviewServiceImp service;
    Review review1,review2;


    @BeforeEach
    void setUp() {
        review1=new Review("7q","8q","9q","fgrg",10,10,10,10);
        review2=new Review("7a","8a","9a","fve",10,10,9,9);
    }

    @AfterEach
    void tearDown() {
        review1=review2=null;

    }
    @Test
    public void givenReviewToSaveShouldReturnSaveReview(){
        Review review3=repository.save(review1);
        assertNotNull(review3);
        assertEquals(review1.getReviewId(),review3.getReviewId());
    }

    @Test
    public void shouldReturnListOfReview(){
        List<Review> list=repository.findAll();
        assertNotNull(list);
    }

}