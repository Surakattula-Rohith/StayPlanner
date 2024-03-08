package com.stackroute.bookingservice.service;

import com.stackroute.bookingservice.exception.BookingIdAlreadyExistException;
import com.stackroute.bookingservice.exception.BookingIdDoesNotExistException;
import com.stackroute.bookingservice.model.BookingHotel;
import com.stackroute.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public BookingHotel addHotelBooking(BookingHotel bookingHotel) throws BookingIdAlreadyExistException {
        Optional<BookingHotel> optionalBookingHotel = bookingRepository.findById(bookingHotel.getBookingId());
        if (optionalBookingHotel.isEmpty()) {
            BookingHotel bookingHotel1 = bookingRepository.save(bookingHotel);
            return bookingHotel1;
        } else {
            throw new BookingIdAlreadyExistException("Booking already exists.");}
    }

    @Override
    public List<BookingHotel> getAllHotelBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingHotel getHotelBookingByBookingId(String bookingId) throws BookingIdDoesNotExistException {
        Optional<BookingHotel> optionalBookingHotel=bookingRepository.findById(bookingId);
        if (optionalBookingHotel.isPresent()){
            BookingHotel bookingHotel=bookingRepository.save(optionalBookingHotel.get());
            return bookingHotel;
        }else {
            throw new BookingIdDoesNotExistException("Booking Id Not Found");
        }
    }
//    public Customer getCustomerById(int id) throws CustomerNotFoundException {
//        Optional<Customer> optionalList = repository.findById(id);
//        if (optionalList.isPresent()) {
//            Customer customer = repository.save(optionalList.get());
//            return customer;
//        } else {
//            throw new CustomerNotFoundException("Id not found");
//        }
//    }

//    @Override
//    public List<BookingHotel> getHotelBookingByCustomerId(String bookingId, String customerId) throws BookingIdDoesNotExistException, CustomerIdDoesNotExist {
//        Optional<BookingHotel> optionalBookingHotel= bookingRepository.findById(bookingId);
//        if(optionalBookingHotel.isPresent()){
//            BookingHotel bookingHotel = bookingRepository.save(optionalBookingHotel.get());
//            return (List<BookingHotel>) bookingHotel;
//        }
//        else {
//            throw new CustomerIdDoesNotExist();
//        }
//    }
//    @Override
//    public List<BookingHotel> getHotelBookingByHotelId(String bookingId, String hotelId) throws BookingIdDoesNotExistException, HotelIdDoesNotExistException {
//        Optional<BookingHotel> optionalBookingHotel= bookingRepository.findById(bookingId);
//
//        if(optionalBookingHotel.isPresent()){
//            BookingHotel bookingHotel = bookingRepository.save(optionalBookingHotel.get());
//            return (List<BookingHotel>) bookingHotel;
//        }
//        else {
//            throw new HotelIdDoesNotExistException();
//        }
//    }
}
