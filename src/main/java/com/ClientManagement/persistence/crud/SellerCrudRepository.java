package com.ClientManagement.persistence.crud;

import com.ClientManagement.persistence.entity.Seller;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SellerCrudRepository extends CrudRepository<Seller,Integer> {

    Optional<List<Seller>> findAllByIdSeller(int idSeller);
}
