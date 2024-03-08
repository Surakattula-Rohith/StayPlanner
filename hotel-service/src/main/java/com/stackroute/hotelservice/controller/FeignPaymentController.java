package com.stackroute.hotelservice.controller;

import com.stackroute.hotelservice.model.OrderResponse;
import com.stackroute.hotelservice.services.FeignPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin("*")
public class FeignPaymentController {
    @Autowired
    FeignPaymentService service;
    @GetMapping("viewallpayment")
    public ResponseEntity<?> view(){
        List<OrderResponse> responseList = service.view();
        return  new ResponseEntity<List>(responseList, HttpStatus.OK);
    }
    @GetMapping("viewbyemail")
    public ResponseEntity<?> viewPaymentIdByEmail(@PathVariable String email){
        return  new ResponseEntity<>(service.getPaymentIdByEmail(email),HttpStatus.OK);
    }
}
