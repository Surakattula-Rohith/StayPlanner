package com.stackroute.bookingservice.service;

import com.stackroute.bookingservice.exception.BookingIdAlreadyExistException;
import com.stackroute.bookingservice.exception.BookingIdDoesNotExistException;
import com.stackroute.bookingservice.model.BookingHotel;

import java.util.List;

public interface BookingService {

    public BookingHotel addHotelBooking(BookingHotel bookingHotel) throws BookingIdAlreadyExistException;
    public List<BookingHotel> getAllHotelBookings();
    public BookingHotel getHotelBookingByBookingId(String bookingId) throws BookingIdDoesNotExistException;


   // public List<BookingHotel> getHotelBookingByHotelId(String bookingId, String hotelId) throws BookingIdDoesNotExistException,HotelIdDoesNotExistException;

    //BookingHotel updateBookingByCustomerId(String customerId, BookingHotel updatedBooking) throws CustomerIdDoesNotExist;

    //boolean deleteBookingByCustomerId(String customerId) throws CustomerIdDoesNotExist;
}

