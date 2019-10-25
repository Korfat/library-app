package library.dao;

import java.util.List;

import library.entity.Book;
import library.entity.Rent;
import library.entity.User;

public interface RentDao {
    void add(Rent rent);

    List<Rent> listRents();

    void returnBook(User user, Book book);

    List<Book> getBooksRentByUser(User user);
}
