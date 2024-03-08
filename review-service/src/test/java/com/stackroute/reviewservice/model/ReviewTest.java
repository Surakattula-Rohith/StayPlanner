package com.stackroute.reviewservice.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {
    Review review;
    @BeforeEach
    void setUp() {
        review = new Review();
    }

    @AfterEach
    void tearDown() {
        review=null;
    }

    @Test
    public void shouldGetReviewId(){

        review.setReviewId("abc");
        assertEquals("abc",review.getReviewId());
    }
}