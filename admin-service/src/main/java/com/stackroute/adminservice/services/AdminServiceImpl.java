package com.stackroute.adminservice.services;

import com.stackroute.adminservice.exception.AdminAlreadyExists;
import com.stackroute.adminservice.exception.AdminIdDoesNotExists;
import com.stackroute.adminservice.model.Admin;
import com.stackroute.adminservice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminRepository repository;
    @Override
    public Admin addAdmin(Admin admin) throws AdminAlreadyExists {
        Admin admin1;
        Optional<Admin> optionalAdmin = repository.findById(admin.getAdminId());
        if (optionalAdmin.isPresent()) {
            throw new AdminAlreadyExists("Id already Exists");
        } else {
            admin1 = repository.save(admin);
            return admin1;
        }
    }

    @Override
    public Optional<Admin> updateAdmin(int id, Admin admin) throws AdminIdDoesNotExists  {
        Admin optional;
        Optional<Admin> optionalAdmin=repository.findById(id);
        if(optionalAdmin.isPresent()){
             optional=repository.save(admin);
             return Optional.of(optional);
        }

        else{
            throw new AdminIdDoesNotExists("Id not exists");
        }
    }

    @Override
    public List<Admin> viewAllAdmin() {
        return repository.findAll();
    }
}
