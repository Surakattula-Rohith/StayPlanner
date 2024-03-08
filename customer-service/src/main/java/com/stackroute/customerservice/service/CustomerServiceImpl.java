package com.stackroute.customerservice.service;

import com.stackroute.customerservice.exceptions.CustomerIdAlreadyExistException;
import com.stackroute.customerservice.exceptions.CustomerNotFoundException;
import com.stackroute.customerservice.model.Customer;
import com.stackroute.customerservice.model.Hotel;
import com.stackroute.customerservice.model.Room;
import com.stackroute.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerDAO {

    private List<Customer> customers = new ArrayList<>();
    private List<Hotel> hotels = new ArrayList<>();
    @Autowired
    CustomerRepository repository;

    @Override
    public Customer addCustomer(Customer customer) throws CustomerIdAlreadyExistException {
        Optional<Customer> optionalCustomer = repository.findById(customer.getCustomerId());
        if (optionalCustomer.isEmpty()) {
            Customer customer1 = repository.save(customer);
            return customer1;
        } else
            throw new CustomerIdAlreadyExistException();

    }

    @Override
    public Customer getCustomerById(int id) throws CustomerNotFoundException {
        Optional<Customer> optionalList = repository.findById(id);
        if (optionalList.isPresent()) {
            Customer customer = repository.save(optionalList.get());
            return customer;
        } else {
            throw new CustomerNotFoundException("Id not found");
        }
    }

    @Override
    public Customer updateCustomer(Customer updatedCustomer) throws CustomerNotFoundException {
        Optional<Customer> existingCustomer = repository.findById(updatedCustomer.getCustomerId());
        if(existingCustomer.isPresent())
        {
            Customer newCustomer;
            newCustomer = repository.save(updatedCustomer);
            return newCustomer;
        }
        else {
            throw new CustomerNotFoundException("Id Not Found");
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        return repository.findAll();
    }

    @Override
    public boolean deleteCustomerById(int id) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = repository.findById(id);
        if(optionalCustomer.isPresent()){
            repository.deleteById(id);
            return true;
        }
        else
            throw new CustomerNotFoundException("Customer Id Not Found");

    }


//    @Override
//    public int getNumberOfAvailableRooms() {
//        int availableRooms = 0;
//        for (Hotel hotel : hotels) {
//            for (Room room : hotel.getRooms()) {
//                if (room.isAvailable()) {
//                    availableRooms++;
//                }
//            }
//        }
//        return availableRooms;
//    }
}

