package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandRepository {

    List<Brand> getAll();
    Optional<List<Brand>> getByBrand(int categoryId);
    Optional<Brand> getBrand(int productId);
    Brand save (Brand product);
    Brand update(Brand product);
    void delete(int brandId);

}
