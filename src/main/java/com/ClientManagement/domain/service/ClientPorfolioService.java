package com.ClientManagement.domain.service;


import com.ClientManagement.domain.dto.ClientPorfolioDTO;
import com.ClientManagement.domain.repository.ClientPorfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientPorfolioService {

    @Autowired
    ClientPorfolioRepository clientPorfolioRepository;

    public List<ClientPorfolioDTO> getAll(){
        return clientPorfolioRepository.getAll();
    }
    public Optional<List<ClientPorfolioDTO>> getByClientPorfolio(int clientPorfolioId){
        return clientPorfolioRepository.getByClientPorfolio(clientPorfolioId);
    }
    public Optional<ClientPorfolioDTO> getClientPorfolio(int clientPorfolioId){
        return clientPorfolioRepository.getClientPorfolio(clientPorfolioId);
    }
    public ClientPorfolioDTO save (ClientPorfolioDTO clientPorfolio){
        return clientPorfolioRepository.save(clientPorfolio);
    }

    public ClientPorfolioDTO update(ClientPorfolioDTO clientPorfolio){
        return clientPorfolioRepository.update(clientPorfolio);
    }
    public boolean delete(int clientPorfolioId){
        if (getClientPorfolio(clientPorfolioId).isPresent()){
            clientPorfolioRepository.delete(clientPorfolioId);
            return true;
        }else{
            return false;
        }
    }

}
