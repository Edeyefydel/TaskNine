package com.Flexisaf.lib_system.models;

import jakarta.persistence.*;

import javax.lang.model.element.Name;
import java.util.List;


@Entity
public class Author {
    @Id
    @Column(name = "id")
    private long author_id;

    @Column(name = "FirstName")
    private String first_name;

    @Column(name = "LastName")
    private String last_name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;


    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
   }
}
