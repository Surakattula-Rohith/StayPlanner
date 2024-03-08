package com.stackroute.adminservice.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    Admin admin;
    @BeforeEach
    void setUp() {
        admin = new Admin();
    }

    @AfterEach
    void tearDown() {
        admin=null;
    }

    @Test
    public void shouldGetAdminId(){

        admin.setAdminId(3);
        assertEquals(3,admin.getAdminId());
    }

    @Test
    public void shouldGetAdminAaadhar(){
        admin.setAadhaarNo("avbc");
        assertEquals("avbc",admin.getAadhaarNo());
    }

}