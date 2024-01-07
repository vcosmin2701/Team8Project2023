package com.lbbsystem.lbbsystem.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Library {
    private Long libraryId;
    private String name;
    private List<User> users;
    private List<Book> books;

    @Id
    @GeneratedValue
    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @OneToMany
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
