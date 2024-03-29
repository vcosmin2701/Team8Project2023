package com.lbbsystem.lbbsystem.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Book {
  @Id
  @GeneratedValue
  private Long id;

  private String category;
  private String isbn;
  private int stock;
  private String author;
  private String title;
  @OneToMany(mappedBy = "book")
  private Collection<BorrowedBook> borrowedBooks;

  public Collection<BorrowedBook> getBorrowedBooks() {
    return borrowedBooks;
  }

  public void setBorrowedBooks(Collection<BorrowedBook> borrowedBooks) {
    this.borrowedBooks = borrowedBooks;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Basic
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }
  @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

  private BookPhoto photo;

    public BookPhoto getPhoto() {
    return photo;
  }

  public void setPhoto(BookPhoto photo) {
    this.photo = photo;
  }
}
