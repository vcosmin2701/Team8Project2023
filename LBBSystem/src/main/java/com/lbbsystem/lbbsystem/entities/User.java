package com.lbbsystem.lbbsystem.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long legitimationNumber;

  public Set<BookLoan> getBookLoans() {
    return bookLoans;
  }

  public void setBookLoans(Set<BookLoan> bookLoans) {
    this.bookLoans = bookLoans;
  }

  @OneToMany(mappedBy = "user")
    private Set<BookLoan> bookLoans = new HashSet<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getLegitimationNumber() {
        return legitimationNumber;
    }

    public void setLegitimationNumber(Long legitimationNumber) {
        this.legitimationNumber = legitimationNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
