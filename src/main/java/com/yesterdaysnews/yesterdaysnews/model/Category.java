package com.yesterdaysnews.yesterdaysnews.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_id_seq")
    @SequenceGenerator(name = "categories_id_seq", sequenceName = "categories_id_seq", allocationSize = 1)
    private int id;

    @NotBlank(message = "Type is required")
    @Size(max = 20, message = "Type must have max 20 characters")
    private String type;

    @ManyToMany
    @JoinTable(name = "article_category", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "article_id"))
    private Set<Article> articles = new HashSet<>();

    public Category() {
    }

    public Category(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
