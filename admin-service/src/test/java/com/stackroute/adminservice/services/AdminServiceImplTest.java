package com.stackroute.adminservice.services;

import com.stackroute.adminservice.model.Admin;
import com.stackroute.adminservice.repository.AdminRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    AdminRepository repository;
    @Autowired
    AdminServiceImpl service;
    Admin admin1,admin2;


    @BeforeEach
    void setUp() {
        admin1=new Admin(1,"abcd efgh","sowjanya","sowji@gmail.com","123456789","12.08.22","delhi");
        admin2=new Admin(2,"asdf asdf","sai","sai@gmail.com","98765432","13.9.06","punjab");

    }

    @AfterEach
    void tearDown() {
        admin1=admin2=null;

    }
    @Test
    public void givenAdminToSaveShouldReturnSaveAdmin(){
        Admin admin3=repository.save(admin1);
        assertNotNull(admin3);
        assertEquals(admin1.getAdminId(),admin3.getAdminId());
    }

    @Test
    public void shouldReturnListOfAdmin(){
        List<Admin> list=repository.findAll();
        assertNotNull(list);
    }

}