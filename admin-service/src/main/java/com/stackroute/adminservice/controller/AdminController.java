package com.stackroute.adminservice.controller;

import com.stackroute.adminservice.exception.AdminAlreadyExists;
import com.stackroute.adminservice.exception.AdminIdDoesNotExists;
import com.stackroute.adminservice.model.Admin;
import com.stackroute.adminservice.services.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    AdminServiceImpl service;
// adding an admin
    @PostMapping("addAdmin")
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin){
        try {
            Admin admin1= service.addAdmin(admin);
            return new ResponseEntity<Admin>(admin1, HttpStatus.CREATED);
        } catch (AdminAlreadyExists e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("viewAdmin")
    public ResponseEntity<?> viewAllAdmin(){
        List<Admin> adminList = service.viewAllAdmin();
        return  new ResponseEntity<List>(adminList,HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable int id,@RequestBody Admin admin){
        Optional admin1= null;
        try {
            admin1 = service.updateAdmin(id, admin);
            return new ResponseEntity<Optional>(admin1,HttpStatus.OK);
        } catch (AdminIdDoesNotExists e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }

    }
}
