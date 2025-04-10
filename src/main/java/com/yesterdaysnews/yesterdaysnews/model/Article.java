package com.yesterdaysnews.yesterdaysnews.model;

import jakarta.persistence.*;

@Entity
@Table(name = "articles")
// Clase que representa un artículo
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //Add validation
    private String title;
    private String content;
    private String publicationDate;
    // usuario aparece aki
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    // categoria aparece aki

    // Constructor de article
    // Plantilla - a adaptar a las necesidades del proyecto
    public Article(int id, String title, String content, String publicationDate, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
        this.user = user;
    }

    // Getters and setters
    public Article() {
        // A propósito!
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
}
}
