package com.stackroute.reviewservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.reviewservice.model.Review;
import com.stackroute.reviewservice.service.ReviewServiceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ReviewControllerTest {

    @InjectMocks
    ReviewController controller;
    @MockBean
    ReviewServiceImp service;

    Review review=new Review();
    MockMvc mvc;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mvc= MockMvcBuilders.standaloneSetup(controller).build();
        review.setReviewId("123");
        review.setCustomerId("456");
        review.setHotelId("789");
        review.setReviewDesc("nice");
        review.setRating(9);
        review.setMaintenance(9);
        review.setAffordability(9);
        review.setWifi(9);
    }

    @AfterEach
    void tearDown() {
        review=null;
    }

    @Test
    public void whenPostObjectSuccess() throws Exception, JsonProcessingException {
        Mockito.when(service.create(review)).thenReturn(review);
        mvc.perform(MockMvcRequestBuilders.post("/reviews/addreviews").contentType(MediaType.APPLICATION_JSON).content(convertObject(review))).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    private String convertObject(Object o) throws JsonProcessingException{
        ObjectMapper objectMapper= new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }


}