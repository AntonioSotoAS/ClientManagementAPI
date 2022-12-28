package com.ClientManagement.domain.service;

import com.ClientManagement.domain.User;
import com.ClientManagement.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }
    public Optional<List<User>> getByUser(int userId){
        return userRepository.getByUser(userId);
    }
    public Optional<User> getUser(int userId){
        return userRepository.getUser(userId);
    }
    public User save (User user){
        return userRepository.save(user);
    }
    public User update(User user){
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
