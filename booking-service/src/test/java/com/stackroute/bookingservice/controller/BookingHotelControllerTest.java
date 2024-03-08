package com.stackroute.bookingservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.bookingservice.model.BookingHotel;
import com.stackroute.bookingservice.service.BookingServiceImpl;
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
class BookingHotelControllerTest {
    @InjectMocks
    BookingHotelController controller;
    @MockBean
    BookingServiceImpl service;

    BookingHotel booking=new BookingHotel();
    MockMvc mvc;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mvc= MockMvcBuilders.standaloneSetup(controller).build();
        booking.setBookingId("2");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void whenPostObjectSuccess() throws Exception, JsonProcessingException {
        Mockito.when(service.addHotelBooking(booking)).thenReturn(booking);
        mvc.perform(MockMvcRequestBuilders.post("/api/bookhotel").contentType(MediaType.APPLICATION_JSON).content(convertObject(booking))).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    private String convertObject(Object o) throws JsonProcessingException{
        ObjectMapper objectMapper= new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }


}