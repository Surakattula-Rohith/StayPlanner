package com.stackroute.adminservice.repository;

import com.stackroute.adminservice.model.Admin;
import com.stackroute.adminservice.services.AdminServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class AdminRepositoryTest {

    @Mock
    AdminRepository repository;
    Admin admin1,admin2;

    List<Admin> adminList;
    @InjectMocks
    AdminServiceImpl service;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        admin1=new Admin(1,"abcd efgh","sowjanya","sowji@gmail.com","123456789","12.08.22","delhi");
        admin2=new Admin(2,"asdf asdf","sai","sai@gmail.com","98765432","13.9.06","punjab");
    }

    @AfterEach
    void tearDown() {
        admin1=null;
        admin2=null;
    }
    @Test
    public void givenAdminRecordToSave(){
        when(repository.save(any())).thenReturn(admin1);
        assertEquals(admin1,repository.save(admin1));
        verify(repository,times(1)).save(any());
    }
    @Test
    public void givenAdminShouldReturnListOfAdmin(){
        repository.save(admin1);
        when(repository.findAll()).thenReturn(adminList);
        List<Admin> adminList1=service.viewAllAdmin();
        assertEquals(adminList,adminList1);
        verify(repository,times(1)).save(admin1);
        verify(repository,times(1)).findAll();
    }

}