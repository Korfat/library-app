package library.dao;

import java.util.List;

import library.entity.Author;

public interface AuthorDao {
    void add(Author author);

    List<Author> listAuthors();

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
