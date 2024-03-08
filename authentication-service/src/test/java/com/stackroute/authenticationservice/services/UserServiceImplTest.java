package com.stackroute.authenticationservice.services;

import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserRepository repository;
    @Autowired
    UserServiceImpl service;
    User user1,user2;

    //    List<User> userList;
    @BeforeEach
    void setUp() {
        user1=new User(1,"sowjanya","abcd","sowji@gmail.com");
        user2=new User(2,"sai","efgh","sai@gmail.com");
//        userList.add(user1);
//        userList.add(user2);
    }

    @AfterEach
    void tearDown() {
        user1=user2=null;
//        userList=null;
    }
    @Test
    public void givenUserToSaveShouldReturnSaveUser(){
        User user3=repository.save(user1);
        assertNotNull(user3);
        assertEquals(user1.getId(),user3.getId());
    }

    @Test
    public void shouldReturnListOfUser(){
        List<User> list=repository.findAll();
        assertNotNull(list);
    }
}