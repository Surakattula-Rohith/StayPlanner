package com.stackroute.bookingservice.controller;

import com.stackroute.bookingservice.exception.BookingIdAlreadyExistException;
import com.stackroute.bookingservice.exception.BookingIdDoesNotExistException;
import com.stackroute.bookingservice.model.BookingHotel;
import com.stackroute.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BookingHotelController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/bookhotel")
    public ResponseEntity<?> addHotelBooking(@RequestBody BookingHotel bookingHotel) throws BookingIdAlreadyExistException {
        try {
            BookingHotel bookingHotel1 = bookingService.addHotelBooking(bookingHotel);
            return new ResponseEntity<BookingHotel>(bookingHotel1, HttpStatus.CREATED);
        } catch (BookingIdAlreadyExistException e) {
            return new ResponseEntity<String>("Booking Id Already Exist in DB", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/allBookings")
    public ResponseEntity<?> getAllHotelBookings() {
        List<BookingHotel> bookingHotelList = bookingService.getAllHotelBookings();
        return new ResponseEntity<List>(bookingHotelList, HttpStatus.OK);
    }

    @GetMapping("getHotelBooking/{bookingId}")
    public ResponseEntity<?> getHotelBookingByBookingId(@PathVariable String bookingId) throws BookingIdDoesNotExistException {
        try {
            BookingHotel bookingHotel= bookingService.getHotelBookingByBookingId(bookingId);
            return new ResponseEntity<BookingHotel>(bookingHotel,HttpStatus.OK);
        } catch (BookingIdDoesNotExistException e) {
            return new ResponseEntity<String>("Booking Id Not Found",HttpStatus.NOT_FOUND);
        }
    }



//    @GetMapping("/getHotelBookingByCustomerId/{bookingId}/{customerId}")
//    public ResponseEntity<?> getHotelBookingByCustomerId(@PathVariable ("bookingId") String bookingId, @PathVariable String customerId) {
//        try{
//            List<BookingHotel> bookingHotels = bookingService.getHotelBookingByCustomerId(bookingId,customerId);
//            return new ResponseEntity<List<BookingHotel>>(bookingHotels,HttpStatus.OK);
//        }catch (BookingIdDoesNotExistException e){
//            return new ResponseEntity<String> ("Invalid Booking Id",HttpStatus.NOT_FOUND);
//        }
//        catch(CustomerIdDoesNotExist e){
//            return new ResponseEntity<String>("Customer id not found",HttpStatus.NOT_FOUND);
//        }
//    }
//    @GetMapping("/getHotelBookingByHotelId/{bookingId}/{hotelId}")
//    public ResponseEntity<?> getHotelBookingByHotelId(@PathVariable ("bookingId") String bookingId, @PathVariable String hotelId) {
//        try{
//            List<BookingHotel> bookingHotels = bookingService.getHotelBookingByHotelId(bookingId,hotelId);
//            return new ResponseEntity<List<BookingHotel>>(bookingHotels,HttpStatus.OK);
//        }catch (BookingIdDoesNotExistException e){
//            return new ResponseEntity<String> ("Invalid Booking Id",HttpStatus.NOT_FOUND);
//        }
//        catch(HotelIdDoesNotExistException e){
//            return new ResponseEntity<String>("Hotel id not found",HttpStatus.NOT_FOUND);
//        }
//    }
}
