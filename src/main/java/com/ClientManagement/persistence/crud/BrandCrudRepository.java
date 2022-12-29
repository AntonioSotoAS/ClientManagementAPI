package com.ClientManagement.persistence.crud;


import com.ClientManagement.persistence.entity.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BrandCrudRepository  extends CrudRepository<Brand,Integer> {

    Optional<List<Brand>> findAllByIdbrand(int idBrand);

}
