package com.ClientManagement.domain.dto;

import com.ClientManagement.domain.Customer;

public class ClientPorfolioDTO {

    private int idClientPorfolio;
    private Customer customer;

    public ClientPorfolioDTO(Customer customer) {
        this.customer = customer;
    }

    public int getIdClientPorfolio() {
        return idClientPorfolio;
    }

    public void setIdClientPorfolio(int idClientPorfolio) {
        this.idClientPorfolio = idClientPorfolio;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ClientPorfolioDTO{" +
                "idClientPorfolio=" + idClientPorfolio +
                ", customer=" + customer +
                '}';
    }
}
