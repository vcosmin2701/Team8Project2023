package com.lbbsystem.lbbsystem.ejb;

import com.lbbsystem.lbbsystem.common.BorrowedBookDto;
import com.lbbsystem.lbbsystem.entities.BorrowedBook;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class BorrowedBookBean {
    private static final Logger LOG = Logger.getLogger(BorrowedBookBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public BorrowedBookDto convertToDto(BorrowedBook borrowedBook) {
        return new BorrowedBookDto(
                borrowedBook.getId(),
                borrowedBook.getBook().getId(),
                borrowedBook.getUser().getUserId(),
                borrowedBook.getBorrowDate(),
                borrowedBook.getReturnDate(),
                borrowedBook.getStatus(),
                borrowedBook.getPeriodLoanInMonths()
        );
    }

    public List<BorrowedBookDto> copyDto(List<BorrowedBook> borrowedBooks) {
        List<BorrowedBookDto> borrowedBookDtoList = new ArrayList<>();
        for (BorrowedBook borrowedBook : borrowedBooks) {
            BorrowedBookDto borrowedBookDto = convertToDto(borrowedBook);
            borrowedBookDtoList.add(borrowedBookDto);
        }
        return borrowedBookDtoList;
    }

    public List<BorrowedBookDto> findAllBorrowedBooks() {
        LOG.info("findAllBorrowedBooks");
        TypedQuery<BorrowedBook> typedQuery = entityManager.createQuery(
                "SELECT b FROM BorrowedBook b WHERE b.status = 'borrowed'",
                BorrowedBook.class);
        List<BorrowedBook> borrowedBooks = typedQuery.getResultList();
        return copyBorrowedBookToDto(borrowedBooks);
    }

    private List<BorrowedBookDto> copyBorrowedBookToDto(List<BorrowedBook> borrowedBooks) {
        List<BorrowedBookDto> borrowedBookDtoList = new ArrayList<>();
        for (BorrowedBook borrowedBook : borrowedBooks) {
            BorrowedBookDto borrowedBookDto = new BorrowedBookDto(
                    borrowedBook.getId(),
                    borrowedBook.getBook().getId(),
                    borrowedBook.getUser().getUserId(),
                    borrowedBook.getBorrowDate(),
                    borrowedBook.getReturnDate(),
                    borrowedBook.getStatus(),
                    borrowedBook.getPeriodLoanInMonths()
            );
            borrowedBookDtoList.add(borrowedBookDto);
        }
        return borrowedBookDtoList;
    }
}
