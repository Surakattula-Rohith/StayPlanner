package com.stackroute.hotelservice.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    Room room;
    @BeforeEach
    void setUp() {
        room = new Room();
    }

    @AfterEach
    void tearDown() {
        room=null;
    }

    @Test
    public void shouldGetRoomId(){

        room.setRoomId("2a");
        assertEquals("2a",room.getRoomId());
    }
}