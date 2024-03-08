package com.stackroute.customerservice.service;

import com.stackroute.customerservice.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("hotel")
public interface HotelFeign {

    @GetMapping("hotel/viewall")
    public List<Hotel> viewAllHotels();

    @GetMapping("hotel/viewbyaddr/{location}")
    public List<Hotel> viewByLocation(@PathVariable String location);

    @GetMapping("hotel/viewbyname/{name}")
    public Hotel getHotelByName(@PathVariable String name);

    @GetMapping("hotel/viewbypricegreaterthan/{maxprice}")
    public List<Hotel> getHotelBasedOnCost(@PathVariable("maxprice") int maxPrice);

}

