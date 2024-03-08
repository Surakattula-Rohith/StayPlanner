package com.stackroute.authenticationservice.controller;

import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.services.UserServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserServiceImpl service ;

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody User profile){
        return new ResponseEntity<User>(service.registerUser(profile), HttpStatus.CREATED);
    }

    @GetMapping("viewAll")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<List>(service.viewUser() , HttpStatus.OK) ;
    }


    @PostMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody User profile){
        boolean result = service.validateUser(profile);
        if(result){
            String  token = generateToken(profile);
            HashMap hashMap = new HashMap();
            hashMap.put("token",token);
            return new ResponseEntity<HashMap>(hashMap,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Invalid Credentails", HttpStatus.UNAUTHORIZED);
        }
    }

    private String generateToken(User profile){
        return Jwts.builder().setSubject(profile.getUserName())
                .setAudience("Rohith")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256,"StayPlanner").compact();
    }

}

