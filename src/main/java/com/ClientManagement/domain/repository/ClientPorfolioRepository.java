package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.ClientPorfolio;
import com.ClientManagement.domain.dto.ClientPorfolioDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClientPorfolioRepository {

    List<ClientPorfolioDTO> getAll();
    Optional<List<ClientPorfolioDTO>> getBySellerId(int clientPorfolioId);
    Optional<ClientPorfolioDTO> getClientPorfolio(int clientPorfolioId);
    ClientPorfolioDTO save (ClientPorfolioDTO clientPorfolio);

    ClientPorfolioDTO update(ClientPorfolioDTO clientPorfolio);
    void delete(int clientPorfolioId);

}
