package com.yesterdaysnews.yesterdaysnews.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   
    @NotBlank(message = "Username is required")
    @Size(min=3, max=20, message = "Username must have min 3 and max 20 characters")
    @Pattern(regexp = "[a-zA-Z0-9_.-]+$", message = "Only letters and numbers are allowed")
    private String username;

    @NotBlank(message = "Email address is required")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message = "Must have email address format")
    private String emailAddress;

    // Preparar aquí la relación con Article
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();

    //Crear getArticles para Delete
    public List<Article> getArticles() {
        return articles;
    }

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
