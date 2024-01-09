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

    public void addBook(BookDto bookDto){
        Book book = new Book();
        LOG.info("addBook");
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getTitle());
        book.setCategory(bookDto.getCategory());
        book.setStock(bookDto.getStock());
        book.setIsbn(bookDto.getIsbn());
        entityManager.persist(book);
    }

    public List<BookDto> findAllBooks() {
        LOG.info("findAllBooks");
        try {
            TypedQuery<Book> typedQuery = entityManager.createQuery("SELECT b FROM Book b", Book.class);
            List<Book> books = typedQuery.getResultList();
            return copyBooksToDto(books);
        } catch(Exception ex) {
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
                    book.getStock(),
                    book.getIsbn()
            );
            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }

    public void deleteBook(Long id) {
        Book book = entityManager.find(Book.class, id);
        if(book != null) {
            entityManager.remove(book);
        }
    }
}
