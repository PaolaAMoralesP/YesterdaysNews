package com.yesterdaysnews.yesterdaysnews.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articles_id_seq")
    @SequenceGenerator(name = "articles_id_seq", sequenceName = "articles_id_seq", allocationSize = 1)
    private int id;

    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title must not exceed 255 characters")
    private String title;

    @NotBlank(message = "Content is required")
    @Size(max = 5000, message = "Content must not exceed 5000 characters")
    @Column(length = 5000)
    private String content;

    @Column(name = "publicationDate")
    private String publicationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(mappedBy = "articles")
    private Set<Category> categories = new HashSet<>();

    // Constructor vacío requerido por JPA
    public Article() {
    }

    // Constructor sin el campo 'id' para evitar problemas con la generación
    // automática
    public Article(int id, String title, String content, String publicationDate, User user, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
        this.user = user;
        this.categories.add(category);
    }

    // Getters y setters
    public int getId() {
        return this.id;
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
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    // Métodos auxiliares para manejar la relación Many-to-Many con Category
    public void addCategory(Category category) {
        this.categories.add(category);
        category.getArticles().add(this);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
        category.getArticles().remove(this);
    }
}
