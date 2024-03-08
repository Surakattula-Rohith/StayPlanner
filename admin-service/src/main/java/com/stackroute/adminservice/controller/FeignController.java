package com.stackroute.adminservice.controller;

import com.stackroute.adminservice.model.Hotel;
import com.stackroute.adminservice.model.HotelOwner;
import com.stackroute.adminservice.services.AdminFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FeignController {
    @Autowired
    AdminFeign adminFeign;

    @GetMapping("getHotelOwner")
    public ResponseEntity<List> getHotelOwner(){
        List<HotelOwner> hotelOwnerList=adminFeign.getAll();
        return new ResponseEntity<>(hotelOwnerList, HttpStatus.OK);
    }

    @PutMapping("updateHotelOwner")
    public ResponseEntity<HotelOwner> update(@RequestBody HotelOwner hotelOwner){
        return new ResponseEntity<HotelOwner>(adminFeign.update(hotelOwner),HttpStatus.OK);
    }
}
