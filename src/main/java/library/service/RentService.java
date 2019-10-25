package library.service;

import java.util.List;

import library.entity.Book;
import library.entity.Rent;
import library.entity.User;

public interface RentService {
    void add(Rent rent);

    List<Rent> listRents();

    Rent rentBook(User user, Book book);

    void returnBook(User user, Book book);

    List<Book> getBooksRentByUser(User user);
}
