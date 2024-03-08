package com.stackroute.bookingservice.exception;

public class BookingIdAlreadyExistException extends Exception{
    public BookingIdAlreadyExistException(String message) {
        super(message);
    }
}
