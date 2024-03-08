package com.stackroute.customerservice.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer;
    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @AfterEach
    void tearDown() {
        customer=null;
    }

    @Test
    public void shouldGetCustomerId(){

        customer.setCustomerId(3);
        assertEquals(3,customer.getCustomerId());
    }
}