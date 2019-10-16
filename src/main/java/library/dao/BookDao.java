package library.dao;

import java.util.List;

import library.entity.Book;

public interface BookDao {
    void add(Book book);

    List<Book> listBooks();
}
