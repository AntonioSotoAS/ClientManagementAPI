package com.ClientManagement.domain.service;

import com.ClientManagement.domain.Brand;
import com.ClientManagement.domain.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAll(){
        return brandRepository.getAll();
    }

    public Optional<Brand> getBrand(int brandId){
        return brandRepository.getBrand(brandId);
    }

    public Optional<List<Brand>> getByBrand(int brandId){
        return brandRepository.getByBrand(brandId);
    }

    public Brand save(Brand brand){
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

    public Brand update(Brand brand){
        return brandRepository.update(brand);
    }



}
