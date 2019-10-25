package library.service;

import java.util.List;
import java.util.Optional;

import library.entity.User;

public interface UserService {
    void add(User user);

    Optional<User> get(Long id);

    List<User> listUsers();
}
