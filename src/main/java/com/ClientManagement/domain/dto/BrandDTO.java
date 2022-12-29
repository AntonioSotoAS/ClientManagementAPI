package com.ClientManagement.domain.dto;

public class BrandDTO {

    private int idBrand;
    private String brand;

    public BrandDTO(String brand) {
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
        return "BrandDTO{" +
                "idBrand=" + idBrand +
                ", brand='" + brand + '\'' +
                '}';
    }
}
