package com.stackroute.notificationservice.controller;

import com.stackroute.notificationservice.model.OrderResponse;
import com.stackroute.notificationservice.service.EmailService;
import com.stackroute.notificationservice.service.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin("*")
@RequestMapping("/email")

public class EmailController {

    @Autowired
    Notification notification;


    @Autowired
    EmailService service;



//    @PostMapping("/sendMail")
//    public String sendMail(@RequestBody OrderResponse orderResponse){
//
//        String status = service.sendSimpleMail(orderResponse);
//        return status;
//    }

    @GetMapping("/payment/data")
    public ResponseEntity<List> view(){
        List<OrderResponse> paymentList = notification.view();
        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody OrderResponse orderResponse){
        ResponseEntity<List> paymentDataResponse = view();
        List<OrderResponse> paymentList = paymentDataResponse.getBody();
        String status = service.sendSimpleMail(orderResponse);
        return status;
    }

    @GetMapping("email/{email}")
    public ResponseEntity<List<OrderResponse>> getByEmail(@PathVariable String email) {
        List<OrderResponse> paymentList = notification.viewPaymentIdByEmail(email);
        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }


}
