package library.service;

import java.util.List;

import library.entity.Book;

public interface BookService {
    void add(Book book);

    List<Book> listBooks();
}
