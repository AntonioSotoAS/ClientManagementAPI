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
    private BrandMapper mapper;

    @Override
    public List<BrandDTO> getAll() {
        return mapper.toBrandDTOs((List<Brand>) brandCrudRepository.findAll());
    }

    @Override
    public Optional<List<BrandDTO>> getByBrand(int brandId) {
        return brandCrudRepository.findAllByIdbrand(brandId)
                .map(brands -> mapper.toBrandDTOs(brands));
    }

    @Override
    public Optional<BrandDTO> getBrand(int brandId) {
        return brandCrudRepository.findById(brandId)
                .map(brand -> mapper.toBrandDTO(brand));
    }

    @Override
    public BrandDTO save(BrandDTO brand) {
        Brand brandEntity = mapper.toBrand(brand);
        return mapper.toBrandDTO(brandCrudRepository.save(brandEntity));
    }

    @Override
    public BrandDTO update(BrandDTO brand) {
        return getBrand(brand.getIdBrand())
                .map(brandtoUpdate -> {
                    brandtoUpdate.setBrand(brand.getBrand());
                    Brand branEntity = mapper.toBrand(brandtoUpdate);
                    return save(mapper.toBrandDTO(branEntity));
                }).orElse(null);
    }

    @Override
    public void delete(int brandId) {
        brandCrudRepository.deleteById(brandId);
    }
}
