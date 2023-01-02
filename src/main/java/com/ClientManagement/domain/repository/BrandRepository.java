package com.ClientManagement.domain.repository;



import com.ClientManagement.domain.dto.BrandDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BrandRepository {

    List<BrandDTO> getAll();
    Optional<BrandDTO> getBrand(int brandId);
    BrandDTO save (BrandDTO brand);
    BrandDTO update(BrandDTO brand);
    void delete(int brandId);

}
