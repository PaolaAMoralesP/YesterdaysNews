package com.yesterdaysnews.yesterdaysnews.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// Clase que representa un artículo
public class Article {
    private int id;
    private String title;
    private String content;
    private String publicationDate;

    // Constructor de article
    // Plantilla - a adaptar a las necesidades del proyecto
    public Article(int id, String title, String content, String publicationDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
    }

    // Getters and setters
public Article(){
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
}
