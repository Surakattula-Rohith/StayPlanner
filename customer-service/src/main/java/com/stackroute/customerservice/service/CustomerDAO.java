package com.stackroute.customerservice.service;

import com.stackroute.customerservice.exceptions.CustomerIdAlreadyExistException;
import com.stackroute.customerservice.exceptions.CustomerNotFoundException;
import com.stackroute.customerservice.model.Customer;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface CustomerDAO {
    public Customer addCustomer(Customer customer) throws CustomerIdAlreadyExistException;
    public Customer getCustomerById(int id) throws CustomerNotFoundException;
    Customer updateCustomer(Customer updatedCustomer) throws CustomerNotFoundException;
    public List<Customer> getAllCustomer();

    boolean deleteCustomerById(int id) throws CustomerNotFoundException;

    //int getNumberOfAvailableRooms();

}
