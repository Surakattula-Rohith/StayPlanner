package com.stackroute.customerservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.customerservice.model.Customer;
import com.stackroute.customerservice.service.CustomerServiceImpl;
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
class CustomerControllerTest {
    @InjectMocks
    CustomerController controller;
    @MockBean
    CustomerServiceImpl service;

    Customer customer=new Customer();
    MockMvc mvc;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mvc= MockMvcBuilders.standaloneSetup(controller).build();
        customer.setCustomerId(1);
        customer.setAadhar("ascf asdc");
        customer.setAddress("goa");
        customer.setDob("july");
        customer.setEmail("sai@gmail.com");
        customer.setName("sowjanya");
        customer.setPhoneNo("1234467");

    }

    @AfterEach
    void tearDown() {
        customer=null;
    }

    @Test
    public void whenPostObjectSuccess() throws Exception, JsonProcessingException {
        Mockito.when(service.addCustomer(customer)).thenReturn(customer);
        mvc.perform(MockMvcRequestBuilders.post("/customers/addcustomer").contentType(MediaType.APPLICATION_JSON).content(convertObject(customer))).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    private String convertObject(Object o) throws JsonProcessingException{
        ObjectMapper objectMapper= new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }



}