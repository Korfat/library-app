package library.service;

import java.util.List;

import library.entity.Author;

public interface AuthorService {
    void add(Author author);

    List<Author> listAuthors();

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
