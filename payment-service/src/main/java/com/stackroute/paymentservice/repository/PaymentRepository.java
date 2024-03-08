package com.stackroute.paymentservice.repository;

import com.stackroute.paymentservice.model.OrderRequest;
import com.stackroute.paymentservice.model.OrderResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<OrderResponse,String> {
    OrderResponse findByEmail(String email);
}
