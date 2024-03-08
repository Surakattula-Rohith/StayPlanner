package com.stackroute.authenticationservice.model;

import jakarta.persistence.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;

    private String mailId ;

    public User(int id, String userName, String password, String mailId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.mailId = mailId;
    }

    public User() {
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
