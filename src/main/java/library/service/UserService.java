package library.service;

import library.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
