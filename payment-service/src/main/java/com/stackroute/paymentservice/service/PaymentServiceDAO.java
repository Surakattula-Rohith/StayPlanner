package com.stackroute.paymentservice.service;

import com.stackroute.paymentservice.model.OrderRequest;
import com.stackroute.paymentservice.model.OrderResponse;

import java.util.List;

public interface PaymentServiceDAO {
    List<OrderResponse> view();

    OrderResponse getPaymentIdByEmail(String email);
}
