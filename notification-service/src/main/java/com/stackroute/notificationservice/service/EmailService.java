package com.stackroute.notificationservice.service;

import com.stackroute.notificationservice.model.OrderResponse;

public interface EmailService {
    String sendSimpleMail( OrderResponse orderResponse);

}
