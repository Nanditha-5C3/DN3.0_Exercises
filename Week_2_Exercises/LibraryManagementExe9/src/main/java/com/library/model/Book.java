package com.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String TITLE;
    private String AUTHOR;

    // Getters and setters
    public Long getId() {
        return ID;
    }

    public void setId(Long id) {
        this.ID = id;
    }

    public String getTitle() {
        return TITLE;
    }

    public void setTitle(String title) {
        this.TITLE = title;
    }

    public String getAuthor() {
        return AUTHOR;
    }

    public void setAuthor(String author) {
        this.AUTHOR = author;
    }
}
