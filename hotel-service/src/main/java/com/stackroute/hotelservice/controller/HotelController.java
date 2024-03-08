package com.stackroute.hotelservice.controller;

import com.stackroute.hotelservice.exception.HotelIdAlreadyExistException;
import com.stackroute.hotelservice.exception.HotelIdDoesNotExistException;
import com.stackroute.hotelservice.model.Hotel;
import com.stackroute.hotelservice.model.Room;
import com.stackroute.hotelservice.services.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("hotel")
@CrossOrigin("*")
public class HotelController {
    @Autowired
    HotelServiceImpl service;

    @PostMapping("/addhotel")

    public ResponseEntity<?> addHotel(@RequestParam(required = false,value = "hotelId") String hotelId,
                                     @RequestParam(required = false,value = "hotelName")String hotelName,
                                     @RequestParam(required = false,value = "hotelAddress")String hotelAddress,
                                     @RequestParam(required = false,value = "location")String location,
                                     @RequestParam(required = false,value = "referalCode")String referalCode,
                                     @RequestParam(required = false,value = "gstNumber")String gstNumber,
                                     @RequestParam(required = false,value = "availability")String availability,
                                     @RequestParam(required = false,value = "acNonAc")String acNonAc,
                                     @RequestParam(required = false,value = "nearbyTransportation")String nearbyTransportation,
                                     @RequestParam(required = false,value = "wifi")String wifi,
                                     @RequestParam(required = false,value = "maintanance")String maintanance,
                                     @RequestParam(required = false,value = "restorent")String restorent,
                                     @RequestParam(required = false,value = "price")int price,
                                     @RequestParam(required = false,value = "roomList") List<Room> roomList,
                                     @RequestParam(required = false,value = "image")MultipartFile image){
        try{
            byte [] hotelImage=null;
            hotelImage=image.getBytes();
            Hotel hotel = new Hotel();
            hotel.setHotelId(hotelId);
            hotel.setHotelName(hotelName);
            hotel.setHotelAddress(hotelAddress);
            hotel.setLocation(location);
            hotel.setReferalCode(referalCode);
            hotel.setGstNumber(gstNumber);
            hotel.setAvailability(availability);
            hotel.setAcNonAc(acNonAc);
            hotel.setNearbyTransportation(nearbyTransportation);
            hotel.setWifi(wifi);
            hotel.setMaintanance(maintanance);
            hotel.setRestoRent(restorent);
            hotel.setPrice(price);
            hotel.setRoomList(roomList);
            hotel.setHotelImage(hotelImage);
            Hotel hotel1 = service.addHotel(hotel);    ///copy
            return new ResponseEntity<Hotel>(hotel1, HttpStatus.CREATED);
        } catch (HotelIdAlreadyExistException | IOException e) {
            return  new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }

    }
    @GetMapping("viewall")
    public ResponseEntity<?> viewAllRooms(){
        List<Hotel> roomList = service.viewAllHotels();
        return  new ResponseEntity<List>(roomList,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{hId}")
    public ResponseEntity<?> deleteHotel(@PathVariable("hId") String hid){
        try {
            boolean result = service.deleteHotelbyHotelId(hid);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HotelIdDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateHotel(@RequestParam(required = false,value = "hotelId") String hotelId,
                                         @RequestParam(required = false,value = "hotelName")String hotelName,
                                         @RequestParam(required = false,value = "hotelAddress")String hotelAddress,
                                         @RequestParam(required = false,value = "location")String location,
                                         @RequestParam(required = false,value = "referalCode")String referalCode,
                                         @RequestParam(required = false,value = "gstNumber")String gstNumber,
                                         @RequestParam(required = false,value = "availability")String availability,
                                         @RequestParam(required = false,value = "acNonAc")String acNonAc,
                                         @RequestParam(required = false,value = "nearbyTransportation")String nearbyTransportation,
                                         @RequestParam(required = false,value = "wifi")String wifi,
                                         @RequestParam(required = false,value = "maintanance")String maintanance,
                                         @RequestParam(required = false,value = "restorent")String restorent,
                                         @RequestParam(required = false,value = "price")int price,
                                         @RequestParam(required = false,value = "roomList") List<Room> roomList,
                                         @RequestParam(required = false,value = "image")MultipartFile image){
        try{
            byte [] hotelImage=null;
            hotelImage=image.getBytes();
            Hotel hotel = new Hotel();
            hotel.setHotelId(hotelId);
            hotel.setHotelName(hotelName);
            hotel.setHotelAddress(hotelAddress);
            hotel.setLocation(location);
            hotel.setReferalCode(referalCode);
            hotel.setGstNumber(gstNumber);
            hotel.setAvailability(availability);
            hotel.setAcNonAc(acNonAc);
            hotel.setNearbyTransportation(nearbyTransportation);
            hotel.setWifi(wifi);
            hotel.setMaintanance(maintanance);
            hotel.setRestoRent(restorent);
            hotel.setPrice(price);
            hotel.setRoomList(roomList);
            hotel.setHotelImage(hotelImage);
            Hotel hotel1 = service.updateHotel(hotel);
            return new ResponseEntity<Hotel>(hotel1,HttpStatus.OK);
        } catch (HotelIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("viewbyId/{hotelId}")
    public Optional<Hotel> viewByHotelId(@PathVariable String hotelId){
        return service.getHotelByHotelId(hotelId);
    }

    @PostMapping("/addroom/{hotelId}")
    public ResponseEntity<?> addHotelModel(@PathVariable String hotelId,
                                           @RequestParam("roomId")String roomId,
                                           @RequestParam(required = false,value = "bedType")String bedType,
                                           @RequestParam(required = false,value = "price")int price,
                                           @RequestParam(required = false,value = "acNonAc")String acNonAc,
                                           @RequestParam(required = false,value = "wifi")String wifi,
                                           @RequestParam(required = false,value = "maintanance")String maintanance,
                                           @RequestParam(required = false,value = "image")MultipartFile image){
        Hotel hotel = null;
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
            hotel = service.addRoom(hotelId, room);
            return new ResponseEntity<Hotel>(hotel,HttpStatus.CREATED);
        } catch (HotelIdDoesNotExistException e) {
            return new ResponseEntity<String>("Invalid Hotel No",HttpStatus.CONFLICT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @GetMapping("viewbyaddr/{location}")
    public ResponseEntity<List> viewByLocation(@PathVariable String location){
        return  new ResponseEntity<List>(service.getHotelByLocation(location),HttpStatus.OK);
    }
    @GetMapping("viewbyname/{name}")
    public ResponseEntity<Hotel> viewByName(@PathVariable String name){
        return  new ResponseEntity<>(service.getHotelByName(name),HttpStatus.OK);
    }
    @GetMapping("viewbypricegreaterthan/{maxprice}")
    public ResponseEntity<?> viewByPrice(@PathVariable int maxprice){
        List<Hotel> hotelList = service.getHotelBasedOnCost(maxprice);
        return new ResponseEntity<List>(hotelList,HttpStatus.OK);
    }

}
