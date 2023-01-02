package com.ClientManagement.persistence;

import com.ClientManagement.domain.dto.UserDTO;
import com.ClientManagement.domain.repository.UserRepository;
import com.ClientManagement.persistence.crud.UserCrudRepository;
import com.ClientManagement.persistence.entity.User;
import com.ClientManagement.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserPersistenceRepository implements UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAll() {
        return userMapper.toUserDTOs((List<User>) userCrudRepository.findAll());
    }


    @Override
    public Optional<UserDTO> getUser(int userId) {
        return userCrudRepository.findById(userId)
                .map(user -> userMapper.toUserDTO(user));
    }

    @Override
    public UserDTO save(UserDTO user) {
        User userEntity = userMapper.toUser(user);
        return userMapper.toUserDTO(userCrudRepository.save(userEntity));
    }

    @Override
    public UserDTO update(UserDTO user) {
        return getUser(user.getIdUserDTO())
                .map(usertoUpdate -> {
                    usertoUpdate.setRoleDTO(user.getRoleDTO());
                    usertoUpdate.setSellerUserDTO(user.getSellerUserDTO());
                    usertoUpdate.setUsernameDTO(user.getUsernameDTO());
                    usertoUpdate.setPasswordDTO(user.getPasswordDTO());
                    User userEntity = userMapper.toUser(usertoUpdate);
                    return save(userMapper.toUserDTO(userEntity));
                }).orElse(null);
    }

    @Override
    public void delete(int userId) {
        userCrudRepository.deleteById(userId);
    }
}
