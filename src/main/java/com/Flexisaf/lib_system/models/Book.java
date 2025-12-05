package com.Flexisaf.lib_system.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Book_id")
    private Long id;

    @Column(name = "Book_title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "published_year")
    private Integer published_year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="author_id", referencedColumnName = "id")
    private Author author;

    @Column(name = "available_copies")
    private Integer available_copies;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublished_year() {
        return published_year;
    }

    public void setPublished_year(Integer published_year) {
        this.published_year = published_year;
    }

    public Author getAuthors() {
        return author;
    }

    public void setAuthors(Author authors) {
        this.author = author;
    }

    public Integer getAvailable_copies() {
        return available_copies;
    }

    public void setAvailable_copies(Integer available_copies) {
        this.available_copies = available_copies;
    }
}
