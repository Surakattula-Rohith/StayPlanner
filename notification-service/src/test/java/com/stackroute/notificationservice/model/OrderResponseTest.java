package com.stackroute.notificationservice.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderResponseTest {
    OrderResponse order;
    @BeforeEach
    void setUp() {
        order = new OrderResponse();
    }

    @AfterEach
    void tearDown() {
        order=null;
    }

    @Test
    public void shouldGetOrderEmail(){

        order.setEmail("abc@gmail.com");
        assertEquals("abc@gmail.com",order.getEmail());
    }

    @Test
    public void shouldGetOrderId(){
        order.setRazorpayOrderId("order_123");
        assertEquals("order_123",order.getRazorpayOrderId());
    }
}