package com.stackroute.paymentservice.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderRequestTest {
    OrderRequest orderRequest;
    @BeforeEach
    void setUp() {
        orderRequest = new OrderRequest();
    }

    @AfterEach
    void tearDown() {
        orderRequest=null;
    }

    @Test
    public void shouldGetCustomerName(){

        orderRequest.setCustomerName("sowjanya");
        assertEquals("sowjanya",orderRequest.getCustomerName());
    }
}