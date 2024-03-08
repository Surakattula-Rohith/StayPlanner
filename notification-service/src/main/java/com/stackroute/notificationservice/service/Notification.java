package com.stackroute.notificationservice.service;

import com.stackroute.notificationservice.model.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(name="payment-order", url="http://localhost:8080")
public interface Notification {
    @GetMapping("/ps/viewall")
    public List<OrderResponse> view();


    @GetMapping("/ps/viewbymail/{email}")
    List<OrderResponse> viewPaymentIdByEmail(@RequestParam("email") String email);
}
