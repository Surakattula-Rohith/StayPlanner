package com.stackroute.adminservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.adminservice.model.Admin;
import com.stackroute.adminservice.services.AdminServiceImpl;
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
class AdminControllerTest {

    @InjectMocks
    AdminController controller;
    @MockBean
    AdminServiceImpl service;

    Admin admin=new Admin();
    MockMvc mvc;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mvc= MockMvcBuilders.standaloneSetup(controller).build();
        admin.setAdminId(12);
        admin.setAadhaarNo("abcd abcd");
        admin.setAdminName("sowjanya");
        admin.setAdminEmail("sowji@gmail.com");
        admin.setMblNo("1234567");
        admin.setDob("12.09.2002");
        admin.setAddress("thailand");
    }

    @AfterEach
    void tearDown() {
        admin=null;
    }

    @Test
    public void whenPostObjectSuccess() throws Exception, JsonProcessingException {
        Mockito.when(service.addAdmin(admin)).thenReturn(admin);
        mvc.perform(MockMvcRequestBuilders.post("/Admin/addAdmin").contentType(MediaType.APPLICATION_JSON).content(convertObject(admin))).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    private String convertObject(Object o) throws JsonProcessingException{
        ObjectMapper objectMapper= new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }

}