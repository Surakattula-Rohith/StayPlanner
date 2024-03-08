package com.stackroute.bookingservice.repository;

import com.stackroute.bookingservice.model.BookingHotel;
import com.stackroute.bookingservice.model.Customer;
import com.stackroute.bookingservice.model.Hotel;
import com.stackroute.bookingservice.service.BookingServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class BookingRepositoryTest {
    @Mock
    BookingRepository repository;
    BookingHotel booking1,booking2;

    List<BookingHotel> bookingList;
    @InjectMocks
    BookingServiceImpl service;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
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
        booking1=null;
        booking2=null;
    }
    @Test
    public void givenBookingRecordToSave(){
        when(repository.save(any())).thenReturn(booking1);
        assertEquals(booking1,repository.save(booking1));
        verify(repository,times(1)).save(any());
    }
    @Test
    public void givenBookingShouldReturnListOfBooking(){
        repository.save(booking1);
        when(repository.findAll()).thenReturn(bookingList);
        List<BookingHotel> bookingList1=service.getAllHotelBookings();
        assertEquals(bookingList,bookingList1);
        verify(repository,times(1)).save(booking1);
        verify(repository,times(1)).findAll();
    }
}