package com.ClientManagement.persistence.crud;


import com.ClientManagement.persistence.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoleCrudRepository extends CrudRepository<Role,Integer> {

    Optional<List<Role>> findAllByIdRole(int role);
}
