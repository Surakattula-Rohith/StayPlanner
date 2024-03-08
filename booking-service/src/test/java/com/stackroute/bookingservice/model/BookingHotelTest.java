package com.stackroute.bookingservice.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingHotelTest {
    BookingHotel booking;
    @BeforeEach
    void setUp() {
        booking = new BookingHotel();
    }

    @AfterEach
    void tearDown() {
        booking=null;
    }

    @Test
    public void shouldGetUserId(){

        booking.setBookingId("3");
        assertEquals("3",booking.getBookingId());
    }
}