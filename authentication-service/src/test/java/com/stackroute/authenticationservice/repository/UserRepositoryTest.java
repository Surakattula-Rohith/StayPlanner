package com.stackroute.authenticationservice.repository;

import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.services.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


    @ExtendWith(MockitoExtension.class)
    class UserRepositoryTest {
        @Mock
        UserRepository repository;
        User user1,user2;

        List<User> userList;
        @InjectMocks
        UserServiceImpl service;
        @BeforeEach
        void setUp() {
            MockitoAnnotations.initMocks(this);
            user1=new User(1,"sowjanya","abcd","sowji@gmail.com");
            user2=new User(2,"sai","efgh","sai@gmail.com");
        }

        @AfterEach
        void tearDown() {
            user1=null;
            user2=null;
        }
        @Test
        public void givenUserRecordToSave(){
            when(repository.save(any())).thenReturn(user1);
            assertEquals(user1,repository.save(user1));
            verify(repository,times(1)).save(any());
        }
        @Test
        public void givenUserShouldReturnListOfUSer(){
            repository.save(user1);
            when(repository.findAll()).thenReturn(userList);
            List<User> userList1=service.viewUser();
            assertEquals(userList,userList1);
            verify(repository,times(1)).save(user1);
            verify(repository,times(1)).findAll();
        }

    }
