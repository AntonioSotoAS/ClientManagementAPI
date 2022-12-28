package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.ClientPorfolio;

import java.util.List;
import java.util.Optional;

public interface ClientPorfolioRepository {

    List<ClientPorfolio> getAll();
    Optional<List<ClientPorfolio>> getByClientPorfolio(int clientPorfolioId);
    Optional<ClientPorfolio> getClientPorfolio(int clientPorfolioId);
    ClientPorfolio save (ClientPorfolio clientPorfolio);

    ClientPorfolio update(ClientPorfolio clientPorfolio);
    void delete(int clientPorfolioId);

}
