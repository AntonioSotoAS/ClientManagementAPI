package com.ClientManagement.domain.service;


import com.ClientManagement.domain.dto.UserDTO;
import com.ClientManagement.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAll(){
        return userRepository.getAll();
    }
    public Optional<UserDTO> getUser(int userId){
        return userRepository.getUser(userId);
    }
    public UserDTO save (UserDTO user){
        return userRepository.save(user);
    }
    public UserDTO update(UserDTO user){
        return userRepository.update(user);
    }
    public boolean delete(int userId){
        if (getUser(userId).isPresent()){
            userRepository.delete(userId);
            return true;
        }else {
            return false;
        }
    }

}
