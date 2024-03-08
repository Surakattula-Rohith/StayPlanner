package com.stackroute.adminservice.services;

import com.stackroute.adminservice.model.Hotel;
import com.stackroute.adminservice.model.HotelOwner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("hotel")
public interface AdminFeign {
    @GetMapping("api/v1/viewallhotelowner")
    public List<HotelOwner> getAll();

    @PutMapping("api/v1/updatehotelowner")
    public HotelOwner update(@RequestBody HotelOwner hotelOwner);
}
