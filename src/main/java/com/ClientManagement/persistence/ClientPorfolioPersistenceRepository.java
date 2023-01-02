package com.ClientManagement.persistence;


import com.ClientManagement.domain.dto.BrandDTO;
import com.ClientManagement.domain.dto.ClientPorfolioDTO;
import com.ClientManagement.domain.repository.BrandRepository;
import com.ClientManagement.domain.repository.ClientPorfolioRepository;
import com.ClientManagement.persistence.crud.BrandCrudRepository;
import com.ClientManagement.persistence.crud.ClientPorfolioCrudRepository;
import com.ClientManagement.persistence.entity.ClientPorfolio;
import com.ClientManagement.persistence.mapper.BrandMapper;
import com.ClientManagement.persistence.mapper.ClientPorfolioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ClientPorfolioPersistenceRepository implements ClientPorfolioRepository {

    @Autowired
    private ClientPorfolioCrudRepository clientPorfolioCrudRepository;

    @Autowired
    private ClientPorfolioMapper clientPorfolioMapper;


    @Override
    public List<ClientPorfolioDTO> getAll() {
        return clientPorfolioMapper.toClientPorfolioDTOs((List<ClientPorfolio>) clientPorfolioCrudRepository.findAll());
    }

    @Override
    public Optional<List<ClientPorfolioDTO>> getBySellerId(int sellerId) {
        return clientPorfolioCrudRepository.findBySeller_IdSeller(sellerId)
                .map(clientPorfolio -> clientPorfolioMapper.toClientPorfolioDTOs(clientPorfolio));
    }

    @Override
    public Optional<ClientPorfolioDTO> getClientPorfolio(int clientPorfolioId) {
        return clientPorfolioCrudRepository.findById(clientPorfolioId)
                .map(clientPorfolio -> clientPorfolioMapper.toClientPorfolioDTO(clientPorfolio));
    }

    @Override
    public ClientPorfolioDTO save(ClientPorfolioDTO clientPorfolio) {
        ClientPorfolio clientPorf = clientPorfolioMapper.toClientPorfolio(clientPorfolio);

        return clientPorfolioMapper.toClientPorfolioDTO(clientPorfolioCrudRepository.save(clientPorf));
    }

    @Override
    public ClientPorfolioDTO update(ClientPorfolioDTO clientPorfolio) {
        return getClientPorfolio(clientPorfolio.getIdClientPorfolioDTO())
                .map(clientPorfoliotoUpdate ->{
                    clientPorfoliotoUpdate.setSellerDTO(clientPorfolio.getSellerDTO());
                    clientPorfoliotoUpdate.setCustomerDTO(clientPorfolio.getCustomerDTO());
                    ClientPorfolio clientPorfo = clientPorfolioMapper.toClientPorfolio(clientPorfoliotoUpdate);
                    return save(clientPorfolioMapper.toClientPorfolioDTO(clientPorfo));
                } ).orElse(null);
    }

    @Override
    public void delete(int clientPorfolioId) {
        clientPorfolioCrudRepository.deleteById(clientPorfolioId);
    }
}
