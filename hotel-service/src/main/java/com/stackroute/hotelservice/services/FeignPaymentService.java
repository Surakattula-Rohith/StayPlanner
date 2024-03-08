package com.stackroute.hotelservice.services;

import com.stackroute.hotelservice.model.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
@FeignClient("Payment-App")
public interface FeignPaymentService {
    @GetMapping("/ps/viewall")
    public List<OrderResponse> view();
//    public List<OrderResponse> view()
    @GetMapping("ps/viewbymail/{email}")
    public OrderResponse getPaymentIdByEmail(String email);


}
