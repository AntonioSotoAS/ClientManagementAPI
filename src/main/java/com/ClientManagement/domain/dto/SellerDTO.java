package com.ClientManagement.domain.dto;

import com.ClientManagement.domain.ClientPorfolio;

import java.util.Arrays;

public class SellerDTO {

    private int idSeller;
    private ClientPorfolio clientPorfolio;

    private int dni;
    private String name;
    private String lastName;
    private byte[] photo;

    public SellerDTO(ClientPorfolio clientPorfolio, int dni, String name, String lastName, byte[] photo) {
        this.clientPorfolio = clientPorfolio;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.photo = photo;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }

    public ClientPorfolio getClientPorfolio() {
        return clientPorfolio;
    }

    public void setClientPorfolio(ClientPorfolio clientPorfolio) {
        this.clientPorfolio = clientPorfolio;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "SellerDTO{" +
                "idSeller=" + idSeller +
                ", clientPorfolio=" + clientPorfolio +
                ", dni=" + dni +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
