package com.ClientManagement.persistence;

import com.ClientManagement.domain.dto.SellerDTO;
import com.ClientManagement.domain.repository.SellerRepository;
import com.ClientManagement.persistence.crud.SellerCrudRepository;
import com.ClientManagement.persistence.entity.Seller;
import com.ClientManagement.persistence.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SellerPersistenceRepository implements SellerRepository {

    @Autowired
    private SellerCrudRepository sellerCrudRepository;

    @Autowired
    private SellerMapper mapper;

    @Override
    public List<SellerDTO> getAll() {
        return mapper.toSellerDTOs((List<Seller>) sellerCrudRepository.findAll());
    }

    @Override
    public Optional<List<SellerDTO>> getBySeller(int sellerId) {
        return sellerCrudRepository.findAllByIdSeller(sellerId)
                .map(sellers -> mapper.toSellerDTOs(sellers));
    }

    @Override
    public Optional<SellerDTO> getSeller(int sellerId) {
        return sellerCrudRepository.findById(sellerId)
                .map(seller -> mapper.toSellerDTO(seller));
    }

    @Override
    public SellerDTO save(SellerDTO seller) {
        Seller sellerEntity = mapper.toSeller(seller);

        return mapper.toSellerDTO(sellerCrudRepository.save(sellerEntity));
    }

    @Override
    public SellerDTO update(SellerDTO seller) {
        return getSeller(seller.getIdSellerDTO())
                .map(sellertoUpdate -> {
                    sellertoUpdate.setDniDTO(seller.getDniDTO());
                    sellertoUpdate.setNameDTO(seller.getNameDTO());
                    sellertoUpdate.setLastNameDTO(seller.getLastNameDTO());
                    Seller sellerEntity = mapper.toSeller(sellertoUpdate);
                    return save(mapper.toSellerDTO(sellerEntity));
                } ).orElse(null);
    }

    @Override
    public void delete(int sellerId) {
        sellerCrudRepository.deleteById(sellerId);
    }
}
