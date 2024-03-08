package com.stackroute.authenticationservice.services;

import com.stackroute.authenticationservice.model.User;

import java.util.List;

public interface UserServiceDAO {
    User registerUser(User profile);
    boolean validateUser(User profile);

    List<User> viewUser() ;
}
