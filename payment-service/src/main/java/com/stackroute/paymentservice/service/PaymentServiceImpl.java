package com.stackroute.paymentservice.service;

import com.stackroute.paymentservice.model.OrderRequest;
import com.stackroute.paymentservice.model.OrderResponse;
import com.stackroute.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentServiceDAO{
    @Autowired
    PaymentRepository repository;
    @Override
    public List<OrderResponse> view() {
        return repository.findAll();
    }

    @Override
    public OrderResponse getPaymentIdByEmail(String email) {
        return repository.findByEmail(email);
    }


}
