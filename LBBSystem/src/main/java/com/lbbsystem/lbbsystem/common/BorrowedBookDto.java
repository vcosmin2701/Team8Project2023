package com.lbbsystem.lbbsystem.common;

import java.util.Date;

public class BorrowedBookDto {
  private Long id;
  private Long bookId;
  private Long userId;
  private Date borrowDate;
  private Date returnDate;
  private String status;
  private int periodLoanInMonths;


  public BorrowedBookDto(Long id, Long bookId, Long userId, Date borrowDate, Date returnDate, String status, int periodLoanInMonths) {
    this.id = id;
    this.bookId = bookId;
    this.userId = userId;
    this.borrowDate = borrowDate;
    this.returnDate = returnDate;
    this.status = status;
    this.periodLoanInMonths = periodLoanInMonths;
  }

  public int getPeriodLoanInMonths() {
    return periodLoanInMonths;
  }

  public void setPeriodLoanInMonths(int periodLoanInMonths) {
    this.periodLoanInMonths = periodLoanInMonths;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
