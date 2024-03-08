package com.stackroute.hotelservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
    String secretId;
    String secretKey;
    String razorpayOrderId;
    String applicationFee;

    String psName;
    String email;

}
