package com.ClientManagement.domain.dto;

import com.ClientManagement.domain.ClientPorfolio;

import java.util.Arrays;

public class SellerDTO {

    private int idSellerDTO;
    private ClientPorfolio clientPorfolioDTO;

    private int dniDTO;
    private String nameDTO;
    private String lastNameDTO;
    private byte[] photoDTO;

    public SellerDTO(ClientPorfolio clientPorfolioDTO, int dniDTO, String nameDTO, String lastNameDTO, byte[] photoDTO) {
        this.clientPorfolioDTO = clientPorfolioDTO;
        this.dniDTO = dniDTO;
        this.nameDTO = nameDTO;
        this.lastNameDTO = lastNameDTO;
        this.photoDTO = photoDTO;
    }

    public int getIdSellerDTO() {
        return idSellerDTO;
    }

    public void setIdSellerDTO(int idSellerDTO) {
        this.idSellerDTO = idSellerDTO;
    }

    public ClientPorfolio getClientPorfolioDTO() {
        return clientPorfolioDTO;
    }

    public void setClientPorfolioDTO(ClientPorfolio clientPorfolioDTO) {
        this.clientPorfolioDTO = clientPorfolioDTO;
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

    public byte[] getPhotoDTO() {
        return photoDTO;
    }

    public void setPhotoDTO(byte[] photoDTO) {
        this.photoDTO = photoDTO;
    }

    @Override
    public String toString() {
        return "SellerDTO{" +
                "idSellerDTO=" + idSellerDTO +
                ", clientPorfolioDTO=" + clientPorfolioDTO +
                ", dniDTO=" + dniDTO +
                ", nameDTO='" + nameDTO + '\'' +
                ", lastNameDTO='" + lastNameDTO + '\'' +
                ", photoDTO=" + Arrays.toString(photoDTO) +
                '}';
    }
}
