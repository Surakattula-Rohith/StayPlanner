package com.stackroute.customerservice.service;

import com.stackroute.customerservice.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("room")
public interface RoomFeign {
//    @GetMapping("room/viewallroom")
//    public List<Room> viewAllRooms();
//
//    @GetMapping("room/viewbyprice/{maxprice}")
//    public List<Room> getRoomsByPrice(@PathVariable("maxprice") int maxPrice);

}
