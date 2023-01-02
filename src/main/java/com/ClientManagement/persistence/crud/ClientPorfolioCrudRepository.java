package com.ClientManagement.persistence.crud;


import com.ClientManagement.persistence.entity.ClientPorfolio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClientPorfolioCrudRepository extends CrudRepository<ClientPorfolio,Integer> {

    Optional<List<ClientPorfolio>> findAllByIdClientPorfolio(int idClient);
    Optional<List<ClientPorfolio>> findBySeller_IdSeller(int sellerId);
}
