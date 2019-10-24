package library.dao;

import java.util.List;
import java.util.Optional;

import library.entity.Book;

public interface BookDao {
    void add(Book book);

    Optional<Book> get(Long id);

    List<Book> listBooks();

    List<Book> findByTitle(String title);
}
