package com.stackroute.authenticationservice.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    @BeforeEach
    void setUp() {
        user = new User();
    }

    @AfterEach
    void tearDown() {
        user=null;
    }

    @Test
    public void shouldGetUserId(){

        user.setId(3);
        assertEquals(3,user.getId());
    }
}