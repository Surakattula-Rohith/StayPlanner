package com.stackroute.reviewservice.exception;

public class ReviewIdDoesNotExistException extends Exception{
    public ReviewIdDoesNotExistException(String message) {
        super(message);
    }
}
