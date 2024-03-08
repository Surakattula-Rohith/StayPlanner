package com.stackroute.hotelservice.controller;

import com.stackroute.hotelservice.model.Review;
import com.stackroute.hotelservice.services.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
public class FeignController {
    @Autowired
    FeignService service;
    @GetMapping("viewallreview")
    public ResponseEntity<List> veiwAllreview(){
        List<Review> reviewList = service.getAllReview();
        return new ResponseEntity<>(reviewList,HttpStatus.OK);
    }
    @PostMapping("rating")
    public ResponseEntity<Review> saverating(@RequestBody Review review){
        return new ResponseEntity<Review>(service.saverating(review), HttpStatus.CREATED);
    }
    @GetMapping("review/{name}")
    public ResponseEntity<List> getreviewByname(@PathVariable String name){
        List<Review> reviewList = service.getByName(name);
        return new ResponseEntity<>(reviewList,HttpStatus.OK);
    }


}
