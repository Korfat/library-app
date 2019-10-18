package library.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;

import library.dao.AuthorDao;
import library.entity.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoImpl implements AuthorDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Author author) {
        sessionFactory.getCurrentSession().save(author);
    }

    @Override
    public List<Author> listAuthors() {
        TypedQuery<Author> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Author", Author.class);
        return query.getResultList();
    }

    @Override
    public List<Author> findByName(String name) {
        TypedQuery<Author> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Author WHERE name LIKE CONCAT('%', :name, '%')", Author.class);
        return query.getResultList();
    }

    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        TypedQuery<Author> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Author WHERE name LIKE CONCAT('%', :name, '%', ) AND "
                        + "surname LIKE CONCAT('%', :surname, '%', )", Author.class);
        return query.getResultList();
    }
}
