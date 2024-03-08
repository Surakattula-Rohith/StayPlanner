package com.stackroute.customerservice.controller;

import com.stackroute.customerservice.model.Room;
import com.stackroute.customerservice.service.RoomFeign;
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
public class FeignRoomController {
    @Autowired
    RoomFeign roomFeign;
//    @GetMapping("room/allRooms")
//    public ResponseEntity<List<Room>> getAllRooms() {
//        List<Room> rooms = roomFeign.viewAllRooms();
//        return new ResponseEntity<>(rooms, HttpStatus.OK);
//    }
//
//    @GetMapping("room/price/{maxprice}")
//    public ResponseEntity<List<Room>> viewByPrice(@PathVariable int maxprice) {
//        List<Room> roomList = roomFeign.getRoomsByPrice(maxprice);
//        return new ResponseEntity<>(roomList, HttpStatus.OK);
//    }
}