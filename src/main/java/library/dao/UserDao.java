package library.dao;

import library.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
