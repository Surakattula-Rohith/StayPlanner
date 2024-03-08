package com.stackroute.hotelservice.controller;

import com.stackroute.hotelservice.exception.HotelIdDoesNotExistException;
import com.stackroute.hotelservice.exception.RoomNoAlreadyExistException;
import com.stackroute.hotelservice.exception.RoomNoDoesNotExistException;
import com.stackroute.hotelservice.model.Room;
import com.stackroute.hotelservice.services.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("room")
@CrossOrigin("*")
public class RoomController {
    @Autowired
    RoomServiceImpl service;

    @PostMapping("/addroom")
    public  ResponseEntity<?> addRoom(@RequestParam("roomId")String roomId,
                                      @RequestParam("bedType")String bedType,
                                      @RequestParam("price")int price,
                                      @RequestParam("acNonAc")String acNonAc,
                                      @RequestParam("wifi")String wifi,
                                      @RequestParam("maintanance")String maintanance,
                                      @RequestParam(required = false,value = "image")MultipartFile image
                                      ){
        try{
            byte [] roomImage=null;
            roomImage=image.getBytes();
            Room room= new Room();
            room.setRoomId(roomId);
            room.setBedType(bedType);
            room.setPrice(price);
            room.setAcNonAc(acNonAc);
            room.setWifi(wifi);
            room.setMaintanance(maintanance);
            room.setRoomImage(roomImage);
            Room room1 = service.addRoom(room);
           return new ResponseEntity<Room>(room1, HttpStatus.CREATED);
        }catch (RoomNoAlreadyExistException | IOException e) {
            return  new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }

    }
    @GetMapping("viewallroom")
    public ResponseEntity<?> viewAllRooms(){
        List<Room> roomList = service.viewAllRooms();
        return  new ResponseEntity<List>(roomList,HttpStatus.OK);
    }
    @DeleteMapping("/deleteroom/{rNo}")
    public ResponseEntity<?> deleteRoom(@PathVariable("rNo") String rno){
        try {
            boolean result = service.deleteRoombyRoomNo(rno);
            return new ResponseEntity<String>("Room Record Deleted",HttpStatus.OK);
        } catch (RoomNoDoesNotExistException e) {
            return new ResponseEntity<String>("Id not Found in DB",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateroom")
    public ResponseEntity<?> updateBlog(@RequestBody Room room){
        try {
            Room room1 = service.updateRoom(room);
            return new ResponseEntity<Room>(room1,HttpStatus.OK);
        } catch (RoomNoDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("viewbyroomNo/{roomNo}")
    public Optional<Room> viewByRoomNo(@PathVariable String roomNo){
        return service.getHotelRoomByRoomNo(roomNo);
    }

    @GetMapping("viewbyprice/{maxprice}")
    public ResponseEntity<?> viewByPrice(@PathVariable int maxprice){
        List<Room> roomList = service.getRoomBasedOnCost(maxprice);
        return new ResponseEntity<List>(roomList,HttpStatus.OK);
    }

}
