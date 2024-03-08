package com.stackroute.authenticationservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.services.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @InjectMocks
    UserController controller;
    @MockBean
    UserServiceImpl service;

    User user = new User();
    MockMvc mvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
        user.setId(12);
        user.setUserName("sowjanya");
        user.setMailId("sowji@gmail.com");
        user.setPassword("abcd");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void whenPostObjectSuccess() throws Exception, JsonProcessingException {
        Mockito.when(service.registerUser(user)).thenReturn(user);
        mvc.perform(MockMvcRequestBuilders.post("/user/register").contentType(MediaType.APPLICATION_JSON).content(convertObject(user))).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    private String convertObject(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }


}