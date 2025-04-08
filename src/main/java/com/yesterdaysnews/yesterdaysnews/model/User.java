package com.yesterdaysnews.yesterdaysnews.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

public class User {
    private int id;
    private String username;
    private String emailAddress;

public User(){}
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

