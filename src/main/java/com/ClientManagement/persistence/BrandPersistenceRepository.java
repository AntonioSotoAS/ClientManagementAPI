package com.ClientManagement.persistence;

import com.ClientManagement.domain.dto.BrandDTO;
import com.ClientManagement.domain.repository.BrandRepository;
import com.ClientManagement.persistence.crud.BrandCrudRepository;
import com.ClientManagement.persistence.entity.Brand;
import com.ClientManagement.persistence.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public class BrandPersistenceRepository implements BrandRepository {

    @Autowired
    private BrandCrudRepository brandCrudRepository;

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<BrandDTO> getAll() {
        return brandMapper.toBrandDTOs((List<Brand>) brandCrudRepository.findAll());
    }

    @Override
    public Optional<BrandDTO> getBrand(int brandId) {
        return brandCrudRepository.findById(brandId)
                .map(brand -> brandMapper.toBrandDTO(brand));
    }

    @Override
    public BrandDTO save(BrandDTO brand) {
        Brand brandEntity = brandMapper.toBrand(brand);
        return brandMapper.toBrandDTO(brandCrudRepository.save(brandEntity));
    }

    @Override
    public BrandDTO update(BrandDTO brand) {
        return getBrand(brand.getIdBrandDTO())
                .map(brandtoUpdate -> {
                    brandtoUpdate.setBrandDTO(brand.getBrandDTO());
                    Brand branEntity = brandMapper.toBrand(brandtoUpdate);
                    return save(brandMapper.toBrandDTO(branEntity));
                }).orElse(null);
    }

    @Override
    public void delete(int brandId) {
        brandCrudRepository.deleteById(brandId);
    }
}
