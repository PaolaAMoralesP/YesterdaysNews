package com.yesterdaysnews.yesterdaysnews.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Type is required")
    @Size(max = 20, message = "Type must have max 20 characters")
    private String type;

    // Plantilla - a adaptar a las necesidades del proyecto
    public Category(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public Category() {

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
}
