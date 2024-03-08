package com.stackroute.customerservice.repository;

import com.stackroute.customerservice.model.Customer;
import com.stackroute.customerservice.service.CustomerServiceImpl;
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
class CustomerRepositoryTest {
    @Mock
    CustomerRepository repository;
    Customer customer1,customer2;

    List<Customer> customerList;
    @InjectMocks
    CustomerServiceImpl service;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        customer1=new Customer();
        customer2=new Customer();
    }

    @AfterEach
    void tearDown() {
        customer1=null;
        customer2=null;
    }
    @Test
    public void givenCustomerRecordToSave(){
        when(repository.save(any())).thenReturn(customer1);
        assertEquals(customer1,repository.save(customer1));
        verify(repository,times(1)).save(any());
    }
    @Test
    public void givenCustomerShouldReturnListOfCustomer(){
        repository.save(customer1);
        when(repository.findAll()).thenReturn(customerList);
        List<Customer> customerList1=service.getAllCustomer();
        assertEquals(customerList,customerList1);
        verify(repository,times(1)).save(customer1);
        verify(repository,times(1)).findAll();
    }


}