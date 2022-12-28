package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {

    List<Role> getAll();
    Optional<List<Role>> getByRole(int roleId);
    Optional<Role> getRole(int roleId);
    Role save (Role role);
    Role update(Role role);
    void delete(int roleId);

}
