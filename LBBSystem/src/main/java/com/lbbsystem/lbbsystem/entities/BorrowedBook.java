package com.lbbsystem.lbbsystem.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "borrowedbook")
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USERID") // corrected reference column name
    private User user;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID") // corrected reference column name
    private Book book;

    @Column(name = "RETURNDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    @Column(name = "BORROWDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date borrowDate;

    @Column(name = "STATUS")
    private String status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }



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

}
