package library.dao;

import java.util.List;

import library.entity.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
