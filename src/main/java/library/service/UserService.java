package library.service;

import java.util.List;

import library.entity.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
