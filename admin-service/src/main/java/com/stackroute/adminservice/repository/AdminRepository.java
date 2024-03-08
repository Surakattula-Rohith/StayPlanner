package com.stackroute.adminservice.repository;

import com.stackroute.adminservice.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin,Integer> {
}
