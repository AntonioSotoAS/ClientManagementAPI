package com.ClientManagement.domain.service;

import com.ClientManagement.domain.Seller;
import com.ClientManagement.domain.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public List<Seller> getAll(){
        return sellerRepository.getAll();
    }
    public Optional<List<Seller>> getBySeller(int sellerId){
        return sellerRepository.getBySeller(sellerId);
    }
    public Optional<Seller> getSeller(int sellerId){
        return sellerRepository.getSeller(sellerId);
    }
    public Seller save (Seller seller){
        return sellerRepository.save(seller);
    }

    public Seller update(Seller seller){
        return sellerRepository.update(seller);
    }
    public boolean delete(int sellerId){
        if (getSeller(sellerId).isPresent()){
            sellerRepository.delete(sellerId);
            return true;
        }else {
            return false;
        }
    }

}
