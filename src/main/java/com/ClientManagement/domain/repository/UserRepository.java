package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.User;
import com.ClientManagement.domain.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository {

    List<UserDTO> getAll();
    Optional<UserDTO> getUser(int userId);
    UserDTO save (UserDTO user);
    UserDTO update(UserDTO user);
    void delete(int userId);

}
