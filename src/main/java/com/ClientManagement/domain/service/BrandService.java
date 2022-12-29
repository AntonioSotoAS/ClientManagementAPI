package com.ClientManagement.domain.service;

import com.ClientManagement.domain.dto.BrandDTO;
import com.ClientManagement.domain.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<BrandDTO> getAll(){
        return brandRepository.getAll();
    }

    public Optional<BrandDTO> getBrand(int brandId){
        return brandRepository.getBrand(brandId);
    }

    public Optional<List<BrandDTO>> getByBrand(int brandId){
        return brandRepository.getByBrand(brandId);
    }

    public BrandDTO save(BrandDTO brand){
        return brandRepository.save(brand);
    }

    public boolean delete(int brandId){

        if (getBrand(brandId).isPresent()){
            brandRepository.delete(brandId);
            return true;
        }else {
            return false;
        }

    }

    public BrandDTO update(BrandDTO brand){
        return brandRepository.update(brand);
    }



}
