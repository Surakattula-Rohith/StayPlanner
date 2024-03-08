package com.stackroute.customerservice.controller;

import com.stackroute.customerservice.exceptions.CustomerIdAlreadyExistException;
import com.stackroute.customerservice.exceptions.CustomerNotFoundException;
import com.stackroute.customerservice.model.Customer;
import com.stackroute.customerservice.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@CrossOrigin("*")
public class CustomerController {


    @Autowired
    CustomerServiceImpl service;

    @PostMapping("/addcustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        try {
            Customer customer1 = service.addCustomer(customer);
            return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);
        } catch (CustomerIdAlreadyExistException e) {
            return new ResponseEntity<String>("Id Already Exist in DB", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getcustomer/{id}")
    public ResponseEntity<?> getCustmoer(@PathVariable int id) throws CustomerNotFoundException {
        try {
            Customer customer = service.getCustomerById(id);

            if (customer == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {

        try {
            Customer updatedCustomer = service.updateCustomer(customer);
            return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("viewall")
    public ResponseEntity<?> getAllMedicince() {
        List<Customer> customerList = service.getAllCustomer();
        return new ResponseEntity<List>(customerList, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCustomerByID(@PathVariable int id){
        try {
            boolean result = service.deleteCustomerById(id);
            return new ResponseEntity<String>("Customer Deleted",HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


}
