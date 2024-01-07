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

    public List<BookDto> findAllBooks(){
        LOG.info("find all books");
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
        for(Book book : books) {
            BookDto bookDto = new BookDto(
                    book.getBookId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getCategory(),
                    book.getIsbn()
            );
            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }

    public void createBook(String title, String author, String category, String isbn){
        LOG.info("createBook");
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory(category);
        book.setIsbn(isbn);

        entityManager.persist(book);
    }

    public BookDto findById(Long bookId) {
        try {
            Book book = entityManager.find(Book.class, bookId);

            if (book != null) {
                return new BookDto(
                        book.getBookId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getCategory(),
                        book.getIsbn()
                );
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void deleteBooksByIds(List<Long> booksIds) {
        LOG.info("deleteBooksByIds");
        for(Long bookId : booksIds) {
            Book book = entityManager.find(Book.class, bookId);
            entityManager.remove(book);
        }
    }
}
