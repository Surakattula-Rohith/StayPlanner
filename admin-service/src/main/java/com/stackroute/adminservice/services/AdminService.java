package com.stackroute.adminservice.services;

import com.stackroute.adminservice.exception.AdminAlreadyExists;
import com.stackroute.adminservice.exception.AdminIdDoesNotExists;
import com.stackroute.adminservice.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    public Admin addAdmin(Admin admin) throws AdminAlreadyExists;

    public Optional<Admin> updateAdmin(int id,Admin admin) throws AdminIdDoesNotExists;

    List<Admin> viewAllAdmin() ;
}
