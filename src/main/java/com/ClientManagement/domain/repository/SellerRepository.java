package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.Seller;
import com.ClientManagement.domain.dto.SellerDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SellerRepository {

    List<SellerDTO> getAll();
    Optional<List<SellerDTO>> getBySeller(int sellerId);
    Optional<SellerDTO> getSeller(int sellerId);
    SellerDTO save (SellerDTO seller);

    SellerDTO update(SellerDTO seller);
    void delete(int sellerId);

}
