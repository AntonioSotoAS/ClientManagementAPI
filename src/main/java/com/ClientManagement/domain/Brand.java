package com.ClientManagement.domain;

import org.springframework.stereotype.Component;

public class Brand {

    private int idBrand;
    private String brand;

    public Brand(String brand) {
        this.brand = brand;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "idBrand=" + idBrand +
                ", brand='" + brand + '\'' +
                '}';
    }
}
