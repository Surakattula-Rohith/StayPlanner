package com.stackroute.hotelservice.controller;

import com.stackroute.hotelservice.exception.*;
import com.stackroute.hotelservice.model.Hotel;
import com.stackroute.hotelservice.model.HotelOwner;
import com.stackroute.hotelservice.model.Image;
import com.stackroute.hotelservice.model.Room;
import com.stackroute.hotelservice.services.HotelOwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class HotelOwnerController {
    @Autowired
    HotelOwnerServiceImpl service;

    // adding the new Hotel Owner
    @PostMapping("/addhotelowner")
    public ResponseEntity<?> addHotelOwner(@RequestParam("ownerId") String ownerId,
                                           @RequestParam(required = false, value = "email") String email,
                                           @RequestParam(required = false, value = "name") String name,
                                           @RequestParam(required = false, value = "mobileNo") String mobileNo,
                                           @RequestParam(required = false, value = "referalCode") String referalCode,
                                           @RequestParam(required = false, value = "addr") String addr,
                                           @RequestParam(required = false, value = "dob") String dob,
                                           @RequestParam(required = false, value = "hotelList") List<Hotel> hotelList,
                                           @RequestParam(required = false,value = "image") MultipartFile image) {
        try {
            byte[] ownerImage = null;
            ownerImage = image.getBytes();
            HotelOwner hotelOwner = new HotelOwner();
            hotelOwner.setOwnerId(ownerId);
            hotelOwner.setName(name);
            hotelOwner.setEmail(email);
            hotelOwner.setAddr(addr);
            hotelOwner.setMobileNo(mobileNo);
            hotelOwner.setReferalCode(referalCode);
            hotelOwner.setDob(dob);
            hotelOwner.setHotelList(hotelList);
            hotelOwner.setOwnerImage(ownerImage);
            HotelOwner hotelOwner1 = service.addHotelOwner(hotelOwner);
            return new ResponseEntity<HotelOwner>(hotelOwner1, HttpStatus.CREATED);
        } catch (HotelOwnerIdAlreadyExistException | IOException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    // fetch the all owner
    @GetMapping("viewallhotelowner")
    public ResponseEntity<?> viewAllHotelOwner() {
        List<HotelOwner> hotelOwnerList = service.viewAllHotelOwner();
        return new ResponseEntity<List>(hotelOwnerList, HttpStatus.OK);
    }

    // delete the owner using owner id
    @DeleteMapping("/deletehotelowner/{oId}")
    public ResponseEntity<?> deleteHotelOwner(@PathVariable("oId") String oid) {
        try {
            boolean result = service.deleteHotelOwnerbyOwnerId(oid);
            return new ResponseEntity<String>("HotelOwner Deleted", HttpStatus.OK);
        } catch (HotelOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>("Id not Found in DB", HttpStatus.NOT_FOUND);
        }
    }

    // update the owner details

    @PutMapping("/updatehotelowner")
    public ResponseEntity<?> updateOwnerDetails(@RequestBody HotelOwner hotelOwner) {
        try {
            HotelOwner hotelOwner1 = service.updateOwner(hotelOwner);
            return new ResponseEntity<HotelOwner>(hotelOwner1, HttpStatus.OK);
        } catch (HotelOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // getting all the data using owner Id
    @GetMapping("viewbyownerId/{ownerId}")
    public Optional<HotelOwner> viewByOwnerId(@PathVariable String ownerId) {
        return service.getOwnerByOwnerId(ownerId);
    }

    //putting the hotel data using ownerId  @RequestBody Hotel hotel
    @PostMapping("/addhotel/{ownerId}")
    public ResponseEntity<?> addHotel(@PathVariable String ownerId, @RequestParam("hotelId") String hotelId,
                                      @RequestParam(required = false, value = "hotelName") String hotelName,
                                      @RequestParam(required = false, value = "hotelAddress") String hotelAddress,
                                      @RequestParam(required = false, value = "location") String location,
                                      @RequestParam(required = false, value = "referalCode") String referalCode,
                                      @RequestParam(required = false, value = "gstNumber") String gstNumber,
                                      @RequestParam(required = false, value = "availability") String availability,
                                      @RequestParam(required = false, value = "acNonAc") String acNonAc,
                                      @RequestParam(required = false, value = "nearbyTransportation") String nearbyTransportation,
                                      @RequestParam(required = false, value = "wifi") String wifi,
                                      @RequestParam(required = false, value = "maintanance") String maintanance,
                                      @RequestParam(required = false, value = "restorent") String restorent,
                                      @RequestParam(required = false, value = "price") int price,
                                      @RequestParam(required = false, value = "roomList") List<Room> roomList,
                                      @RequestParam(required = false,value = "image") MultipartFile image) {
        HotelOwner hotelOwner = null;
        try {
            byte[] hotelImage = null;
            hotelImage = image.getBytes();
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

            hotelOwner = service.addHotel(ownerId, hotel);
            return new ResponseEntity<HotelOwner>(hotelOwner, HttpStatus.CREATED);
        } catch (HotelOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




//    @GetMapping("viewbyaddr/{addr}")
//    public ResponseEntity<List> viewByAddress(@PathVariable String addr){
//        return  new ResponseEntity<List>(service.getHotelOwnerByAddr(addr),HttpStatus.OK);
//    }


    @DeleteMapping("/delete/hotel/{ownerId}/{hotelId}")
    public ResponseEntity<?> deletehotel(@PathVariable String ownerId, @PathVariable String hotelId){
        try {
            boolean result = service.deleteHotel(ownerId,hotelId);
            return  new ResponseEntity<String>("Hotel is Deleted",HttpStatus.OK);
        } catch (HotelOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>("Invalid Owner id",HttpStatus.NOT_FOUND);
        } catch (HotelIdDoesNotExistException e) {
            return new ResponseEntity<String>("Hotel id not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/viewbyname/hotel/{ownerId}/{hotelName}")
    public ResponseEntity<?> getHotelByName(@PathVariable("ownerId") String ownerId, @PathVariable String hotelName){
        try {
            Hotel hotel = service.getHotelByName(ownerId,hotelName);
            return new ResponseEntity<Hotel>(hotel,HttpStatus.OK);
        } catch (HotelOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>("Invalid Owner id",HttpStatus.NOT_FOUND);
        } catch (HotelNameNotFoundException e) {
            return new ResponseEntity<String>("Hotel id not found",HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/viewbylocation/hotel/{ownerId}/{hotelAddress}")
    public ResponseEntity<?> getHotelByAddress(@PathVariable("ownerId") String ownerId, @PathVariable String hotelAddress){
        try {
            Hotel hotel = service.getHotelByAddress(ownerId,hotelAddress);
            return new ResponseEntity<Hotel>(hotel,HttpStatus.OK);
        } catch (HotelOwnerIdDoesNotExistException e) {
            return new ResponseEntity<String>("Invalid Owner id",HttpStatus.NOT_FOUND);
        } catch (HotelNameNotFoundException e) {
            return new ResponseEntity<String>("Hotel not found",HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("getData")
    public ResponseEntity<?> getFakeData(){
        RestTemplate template = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/users";
        ResponseEntity<String> response = null;
        response = template.exchange(url, HttpMethod.GET,getEntity(),String.class);
        return  new ResponseEntity<String>(response.getBody(),HttpStatus.OK);
    }
    private HttpEntity getEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity(headers);
    }
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<String>(service.addFile(file), HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<ByteArrayResource> view(@PathVariable String id) throws IOException {
        Image image = service.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getFileType() ))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFilename() + "\"")
                .body(new ByteArrayResource(image.getFile()));
    }


}
