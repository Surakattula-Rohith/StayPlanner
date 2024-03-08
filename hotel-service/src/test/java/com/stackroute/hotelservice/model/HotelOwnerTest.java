package com.stackroute.hotelservice.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelOwnerTest {
    HotelOwner hotelOwner;
    @BeforeEach
    void setUp() {
        hotelOwner = new HotelOwner();
    }

    @AfterEach
    void tearDown() {
        hotelOwner=null;
    }

    @Test
    public void shouldGetOwnerId(){

        hotelOwner.setOwnerId("2q");
        assertEquals("2q",hotelOwner.getOwnerId());
    }
}