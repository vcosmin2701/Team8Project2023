package com.lbbsystem.lbbsystem.ejb;

import com.lbbsystem.lbbsystem.common.BookDto;
import com.lbbsystem.lbbsystem.common.BookPhotoDto;
import com.lbbsystem.lbbsystem.entities.Book;
import com.lbbsystem.lbbsystem.entities.BookPhoto;
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
                    String.valueOf(book.getStock())
            );
            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }
    public void addPhotoToBook(Long bookId, String filename, String fileType, byte[] fileContent) {
        LOG.info("addPhotoToBook");
        BookPhoto photo = new BookPhoto();
        photo.setFilename(filename);
        photo.setFileType(fileType);
        photo.setFileContent(fileContent);
        Book book = entityManager.find(Book.class, bookId);
        if (book.getPhoto() != null) {
            entityManager.remove(book.getPhoto());
        }
        book.setPhoto(photo);
        photo.setBook(book);
        entityManager.persist(photo);
    }
    public BookPhotoDto findPhotoByBookId(Integer bookId) {
        List<BookPhoto> photos = entityManager
                .createQuery("SELECT p FROM BookPhoto p where p.book.id = :id", BookPhoto.class)
                .setParameter("id", bookId)
                .getResultList();
        if (photos.isEmpty()) {
            return null;
        }
        BookPhoto photo = photos.get(0);
        return new BookPhotoDto(photo.getId(), photo.getFilename(), photo.getFileType(),
                photo.getFileContent());
    }
}
