package com.ClientManagement.persistence.crud;


import com.ClientManagement.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserCrudRepository extends CrudRepository<User,Integer> {

    Optional<List<User>> findAllByIdUser(int idUser);

    Optional<User> findByUsername(String username);

}
