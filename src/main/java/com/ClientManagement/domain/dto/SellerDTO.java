package com.ClientManagement.domain.dto;

import com.ClientManagement.domain.ClientPorfolio;

import java.util.Arrays;

public class SellerDTO {

    private int idSellerDTO;
    private int dniDTO;
    private String nameDTO;
    private String lastNameDTO;


    public SellerDTO(int dniDTO, String nameDTO, String lastNameDTO) {
        this.dniDTO = dniDTO;
        this.nameDTO = nameDTO;
        this.lastNameDTO = lastNameDTO;
    }

    public int getIdSellerDTO() {
        return idSellerDTO;
    }

    public void setIdSellerDTO(int idSellerDTO) {
        this.idSellerDTO = idSellerDTO;
    }

    public int getDniDTO() {
        return dniDTO;
    }

    public void setDniDTO(int dniDTO) {
        this.dniDTO = dniDTO;
    }

    public String getNameDTO() {
        return nameDTO;
    }

    public void setNameDTO(String nameDTO) {
        this.nameDTO = nameDTO;
    }

    public String getLastNameDTO() {
        return lastNameDTO;
    }

    public void setLastNameDTO(String lastNameDTO) {
        this.lastNameDTO = lastNameDTO;
    }

    @Override
    public String toString() {
        return "SellerDTO{" +
                "idSellerDTO=" + idSellerDTO +
                ", dniDTO=" + dniDTO +
                ", nameDTO='" + nameDTO + '\'' +
                ", lastNameDTO='" + lastNameDTO + '\'' +
                '}';
    }
}
