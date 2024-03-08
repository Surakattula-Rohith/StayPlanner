package com.stackroute.reviewservice.repository;

import com.stackroute.reviewservice.model.Review;
import com.stackroute.reviewservice.service.ReviewServiceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ReviewRepositoryTest {

    @Mock
    ReviewRepository repository;
    Review review1,review2;

    List<Review> reviewList;
    @InjectMocks
    ReviewServiceImp service;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        review1=new Review("7q","8q","9q","fgrg",10,10,10,10);
        review2=new Review("7a","8a","9a","fve",10,10,9,9);
    }

    @AfterEach
    void tearDown() {
        review1=null;
        review2=null;
    }
    @Test
    public void givenReviewRecordToSave(){
        when(repository.save(any())).thenReturn(review1);
        assertEquals(review1,repository.save(review1));
        verify(repository,times(1)).save(any());
    }
    @Test
    public void givenReviewShouldReturnListOfReview(){
        repository.save(review1);
        when(repository.findAll()).thenReturn(reviewList);
        List<Review> reviewList1=service.getReviews();
        assertEquals(reviewList,reviewList1);
        verify(repository,times(1)).save(review1);
        verify(repository,times(1)).findAll();
    }

}