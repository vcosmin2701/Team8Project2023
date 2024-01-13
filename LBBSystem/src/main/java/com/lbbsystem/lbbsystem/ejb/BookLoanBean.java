package com.lbbsystem.lbbsystem.ejb;

import com.lbbsystem.lbbsystem.common.BookLoanDto;
import com.lbbsystem.lbbsystem.entities.BookLoan;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class BookLoanBean {
    private static final Logger LOG = Logger.getLogger(BookLoanBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

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

    public List<BookLoanDto> copyDto(List<BookLoan> bookLoans) {
        List<BookLoanDto> bookLoanDtoList = new ArrayList<>();
        for (BookLoan bookLoan : bookLoans) {
            BookLoanDto bookLoanDto = convertToDto(bookLoan);
            bookLoanDtoList.add(bookLoanDto);
        }
        return bookLoanDtoList;
    }

    public List<BookLoanDto> findAllBookLoans() {
        TypedQuery<BookLoan> typedQuery = entityManager.createQuery("SELECT b FROM BookLoan b", BookLoan.class);
        List<BookLoan> bookLoans = typedQuery.getResultList();
        return copyDto(bookLoans);
    }
}
