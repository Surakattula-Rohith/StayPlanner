package com.stackroute.bookingservice.service;

import com.stackroute.bookingservice.model.BookingHotel;
import com.stackroute.bookingservice.model.Customer;
import com.stackroute.bookingservice.model.Hotel;
import com.stackroute.bookingservice.repository.BookingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingServiceImplTest {
    @Autowired
    BookingRepository repository;
    @Autowired
    BookingServiceImpl service;
    BookingHotel booking1,booking2;


    @BeforeEach
    void setUp() {
        DateFormat form=new SimpleDateFormat("23/08/2023");
        Date obj= new Date();
        Hotel hotel;
        hotel=new Hotel();
        Customer customer;
        customer=new Customer();
        booking1=new BookingHotel("1",customer,hotel,obj,obj,"dfe");
        booking2=new BookingHotel("1",customer,hotel,obj,obj,"dfe");
    }

    @AfterEach
    void tearDown() {
        booking1=booking2=null;

    }
    @Test
    public void givenBookingToSaveShouldReturnSaveBooking(){
        BookingHotel booking3=repository.save(booking1);
        assertNotNull(booking3);
        assertEquals(booking1.getBookingId(),booking3.getBookingId());
    }

    @Test
    public void shouldReturnListOfBookings(){
        List<BookingHotel> list=repository.findAll();
        assertNotNull(list);
    }
}