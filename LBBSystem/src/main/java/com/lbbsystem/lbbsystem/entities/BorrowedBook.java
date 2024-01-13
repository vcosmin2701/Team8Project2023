package com.lbbsystem.lbbsystem.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class BorrowedBook {
    @Id
    @GeneratedValue
    private Long id;

    private User user;
    @ManyToOne
    @JoinColumn(name = "id_user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    private Date borrowDate;
    private Date returnDate;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Basic
    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
