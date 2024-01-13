package com.lbbsystem.lbbsystem.common;

import com.lbbsystem.lbbsystem.entities.BookLoan;

import java.util.Date;

public class BookLoanDto {
    private Long id;
    private Long bookId;
    private Long userId;
    private Date borrowDate;
    private Date returnDate;
    private String status;

    public BookLoanDto(Long id, Long bookId, Long userId, Date borrowDate, Date returnDate, String status) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public BookLoanDto convertToDto(BookLoan bookLoan) {
        return new BookLoanDto(
                bookLoan.getId(),
                bookLoan.getBook().getId(),
                bookLoan.getUser().getUserId(),
                bookLoan.getBorrowDate(),
                bookLoan.getReturnDate(),
                bookLoan.getStatus()
        );
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
}
