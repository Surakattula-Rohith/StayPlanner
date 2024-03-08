package com.stackroute.hotelservice.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    Hotel hotel;
    @BeforeEach
    void setUp() {
        hotel = new Hotel();
    }

    @AfterEach
    void tearDown() {
        hotel=null;
    }

    @Test
    public void shouldGetHotelId(){
        hotel.setHotelId("3a");
        assertEquals("3a",hotel.getHotelId());
    }
}