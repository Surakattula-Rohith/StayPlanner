package com.stackroute.authenticationservice.services;

import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceDAO {
    @Autowired
    UserRepository repo;

    @Override
    public User registerUser(User profile) {
        return repo.save(profile);
    }


    @Override
    public boolean validateUser(User profile) {
        User profile1 = repo.findByMailIdAndPassword(profile.getMailId(), profile.getPassword());
        if(profile1 == null){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public List<User> viewUser() {
        return repo.findAll();
    }
}
