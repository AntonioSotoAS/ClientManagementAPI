package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerRepository {

    List<Seller> getAll();
    Optional<List<Seller>> getBySeller(int sellerId);
    Optional<Seller> getSeller(int sellerId);
    Seller save (Seller seller);

    Seller update(Seller seller);
    void delete(int sellerId);

}
