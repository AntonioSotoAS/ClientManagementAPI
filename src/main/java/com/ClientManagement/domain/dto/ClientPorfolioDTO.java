package com.ClientManagement.domain.dto;

import com.ClientManagement.domain.Customer;

public class ClientPorfolioDTO {

    private int idClientPorfolioDTO;

    private SellerDTO sellerDTO;
    private CustomerDTO customerDTO;


    public ClientPorfolioDTO(SellerDTO sellerDTO, CustomerDTO customerDTO) {
        this.sellerDTO = sellerDTO;
        this.customerDTO = customerDTO;
    }

    public int getIdClientPorfolioDTO() {
        return idClientPorfolioDTO;
    }

    public void setIdClientPorfolioDTO(int idClientPorfolioDTO) {
        this.idClientPorfolioDTO = idClientPorfolioDTO;
    }

    public SellerDTO getSellerDTO() {
        return sellerDTO;
    }

    public void setSellerDTO(SellerDTO sellerDTO) {
        this.sellerDTO = sellerDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    @Override
    public String toString() {
        return "ClientPorfolioDTO{" +
                "idClientPorfolioDTO=" + idClientPorfolioDTO +
                ", sellerDTO=" + sellerDTO +
                ", customerDTO=" + customerDTO +
                '}';
    }
}
