package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> getAll();
    Optional<List<User>> getByUser(int userId);
    Optional<User> getUser(int userId);
    User save (User user);
    User update(User user);
    void delete(int userId);

}
