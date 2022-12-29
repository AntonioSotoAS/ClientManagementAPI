package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.ClientPorfolio;
import com.ClientManagement.domain.dto.ClientPorfolioDTO;

import java.util.List;
import java.util.Optional;

public interface ClientPorfolioRepository {

    List<ClientPorfolioDTO> getAll();
    Optional<List<ClientPorfolioDTO>> getByClientPorfolio(int clientPorfolioId);
    Optional<ClientPorfolioDTO> getClientPorfolio(int clientPorfolioId);
    ClientPorfolioDTO save (ClientPorfolioDTO clientPorfolio);

    ClientPorfolioDTO update(ClientPorfolioDTO clientPorfolio);
    void delete(int clientPorfolioId);

}
