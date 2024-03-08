package com.stackroute.customerservice.service;

import com.stackroute.customerservice.model.Customer;
import com.stackroute.customerservice.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


    @SpringBootTest
    class CustomerServiceImplTest {
        @Autowired
        CustomerRepository repository;
        @Autowired
        CustomerServiceImpl service;
        Customer customer1,customer2;


        @BeforeEach
        void setUp() {
            customer1=new Customer();
            customer2=new Customer();
        }

        @AfterEach
        void tearDown() {
            customer1 = customer2 = null;

        }

        @Test
        public void shouldReturnListOfUser(){
            List<Customer> list=repository.findAll();
            assertNotNull(list);
        }
    }
