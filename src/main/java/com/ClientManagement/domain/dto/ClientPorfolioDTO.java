package com.ClientManagement.domain.dto;

import com.ClientManagement.domain.Customer;

public class ClientPorfolioDTO {

    private int idClientPorfolioDTO;
    private Customer customerDTO;

    public ClientPorfolioDTO(Customer customerDTO) {
        this.customerDTO = customerDTO;
    }

    public int getIdClientPorfolioDTO() {
        return idClientPorfolioDTO;
    }

    public void setIdClientPorfolioDTO(int idClientPorfolioDTO) {
        this.idClientPorfolioDTO = idClientPorfolioDTO;
    }

    public Customer getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(Customer customerDTO) {
        this.customerDTO = customerDTO;
    }

    @Override
    public String toString() {
        return "ClientPorfolioDTO{" +
                "idClientPorfolioDTO=" + idClientPorfolioDTO +
                ", customerDTO=" + customerDTO +
                '}';
    }
}
