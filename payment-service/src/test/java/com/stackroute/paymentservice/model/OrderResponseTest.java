package com.stackroute.paymentservice.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderResponseTest {
    OrderResponse orderResponse;
    @BeforeEach
    void setUp() {
        orderResponse = new OrderResponse();
    }

    @AfterEach
    void tearDown() {
        orderResponse=null;
    }

    @Test
    public void shouldGetCustomerEmail(){

        orderResponse.setEmail("sai@gmail.com");
        assertEquals("sai@gmail.com",orderResponse.getEmail());
    }
}