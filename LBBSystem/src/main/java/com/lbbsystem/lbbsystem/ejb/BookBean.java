package com.lbbsystem.lbbsystem.ejb;

import com.lbbsystem.lbbsystem.common.BookDto;
import com.lbbsystem.lbbsystem.entities.Book;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class BookBean {
    private static final Logger LOG = Logger.getLogger(BookBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    public List<BookDto> findAllBooks() {
        LOG.info("findAllBooks");
        try {
            TypedQuery<Book> typedQuery = entityManager.createQuery("SELECT b FROM Book b", Book.class);
            List<Book> books = typedQuery.getResultList();
            return copyBooksToDto(books);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<BookDto> copyBooksToDto(List<Book> books) {
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book : books) {
            BookDto bookDto = new BookDto(
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getCategory(),
                    String.valueOf(book.getStock())
            );
            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }

    public List<BookDto> findBooksSortedBy(String sortOption) {
        LOG.info("findBooksSortedBy: " + sortOption);
        try {
            String orderByClause = determineOrderByClause(sortOption);
            TypedQuery<Book> typedQuery = entityManager.createQuery("SELECT b FROM Book b " + orderByClause, Book.class);
            List<Book> books = typedQuery.getResultList();
            return copyBooksToDto(books);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private String determineOrderByClause(String sortOption) {
        switch (sortOption) {
            case "author-a-z":
                return "ORDER BY b.author ASC";
            case "author-z-a":
                return "ORDER BY b.author DESC";
            case "title-a-z":
                return "ORDER BY b.title ASC";
            case "title-z-a":
                return "ORDER BY b.title DESC";
            default:
                return "";
        }
    }

    public List<BookDto> searchBooks(String query) {
        TypedQuery<Book> typedQuery = entityManager.createQuery(
                "SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(:query) OR LOWER(b.author) LIKE LOWER(:query)",
                Book.class);
        typedQuery.setParameter("query", "%" + query + "%");
        List<Book> books = typedQuery.getResultList();
        return copyBooksToDto(books);
    }

    public List<BookDto> findBooksByCategory(String category) {
        if (category == null || category.isEmpty()) {
            return findAllBooks();
        }
        if (!"Others".equals(category)) {
            TypedQuery<Book> typedQuery = entityManager.createQuery("SELECT b FROM Book b WHERE b.category = :category", Book.class);
            typedQuery.setParameter("category", category);
            List<Book> books = typedQuery.getResultList();
            return copyBooksToDto(books);
        } else {
            TypedQuery<Book> typedQuery = entityManager.createQuery(
                    "SELECT b FROM Book b WHERE b.category NOT IN ('Science', 'Detective', 'Love', 'Novel', 'History')", Book.class);
            List<Book> books = typedQuery.getResultList();
            return copyBooksToDto(books);
        }

    }

}
