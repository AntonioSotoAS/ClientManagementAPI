package com.ClientManagement.persistence.crud;


import com.ClientManagement.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User,Integer> {

    Optional<List<User>> findAllByIdUser(int idUser);

}
