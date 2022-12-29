package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.User;
import com.ClientManagement.domain.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<UserDTO> getAll();
    Optional<List<UserDTO>> getByUser(int userId);
    Optional<UserDTO> getUser(int userId);
    UserDTO save (UserDTO user);
    UserDTO update(UserDTO user);
    void delete(int userId);

}
