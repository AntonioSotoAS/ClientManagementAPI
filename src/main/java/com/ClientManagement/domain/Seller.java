package com.ClientManagement.domain;

import java.util.Arrays;

public class Seller {

    private int idSeller;
    private int dni;
    private String name;
    private String lastName;

    public Seller(int idSeller, int dni, String name, String lastName) {
        this.idSeller = idSeller;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
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

    @Override
    public String toString() {
        return "Seller{" +
                "idSeller=" + idSeller +
                ", dni=" + dni +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
