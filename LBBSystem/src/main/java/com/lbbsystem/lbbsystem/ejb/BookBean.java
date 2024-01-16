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

    public Long addBook(BookDto bookDto){
        Book book = new Book();
        LOG.info("addBook");
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setCategory(bookDto.getCategory());
        book.setStock(bookDto.getStock());
        book.setIsbn(bookDto.getIsbn());
        entityManager.persist(book);
        return book.getId();
    }

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
                    book.getStock(),
                    book.getIsbn()
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
  public BookPhotoDto findPhotoByBookId(Long bookId) {
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

    public void deleteBook(Long id) {
        Book book = entityManager.find(Book.class, id);
        if(book != null) {
            entityManager.remove(book);
        }
    }

    public BookDto findBookById(Long id){
        Book book = entityManager.find(Book.class, id);
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getStock(), book.getIsbn());
    }

    public void updateBook(BookDto bookDto) {
        Book book = entityManager.find(Book.class, bookDto.getId());
        if (book != null) {
            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setCategory(bookDto.getCategory());
            book.setStock(bookDto.getStock());
            book.setIsbn(bookDto.getIsbn());
            entityManager.merge(book);
        }
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
    public List<BookDto> findBooksInStock() {
        TypedQuery<Book> query = entityManager.createQuery(
                "SELECT b FROM Book b WHERE b.stock > 0", Book.class);
        List<Book> books = query.getResultList();
        return copyBooksToDto(books);
    }
}
