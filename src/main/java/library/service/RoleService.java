package library.service;

import java.util.List;
import java.util.Optional;

import library.entity.Role;

public interface RoleService {
    void add(Role role);

    Optional<Role> getRoleByName(String name);

    List<Role> getAllRoles();
}
