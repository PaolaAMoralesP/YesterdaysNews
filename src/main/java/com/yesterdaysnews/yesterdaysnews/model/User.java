package com.yesterdaysnews.yesterdaysnews.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   
    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty(message = "Email address is required")
    private String emailAddress;
    

    // Plantilla - a adaptar a las necesidades del proyecto
    public User(int id, String username, String emailAddress) {
        this.id = id;
        this.username = username;
        this.emailAddress = emailAddress;
    }

    // Spring Boot autogenera este constructor por defecto utilizando los getters y
    // setters en @RequestBody
    public User() {

    }

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
