package com.ClientManagement.domain.service;

import com.ClientManagement.domain.ClientPorfolio;
import com.ClientManagement.domain.repository.ClientPorfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientPorfolioService {

    @Autowired
    ClientPorfolioRepository clientPorfolioRepository;

    public List<ClientPorfolio> getAll(){
        return clientPorfolioRepository.getAll();
    }
    public Optional<List<ClientPorfolio>> getByClientPorfolio(int clientPorfolioId){
        return clientPorfolioRepository.getByClientPorfolio(clientPorfolioId);
    }
    public Optional<ClientPorfolio> getClientPorfolio(int clientPorfolioId){
        return clientPorfolioRepository.getClientPorfolio(clientPorfolioId);
    }
    public ClientPorfolio save (ClientPorfolio clientPorfolio){
        return clientPorfolioRepository.save(clientPorfolio);
    }

    public ClientPorfolio update(ClientPorfolio clientPorfolio){
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
