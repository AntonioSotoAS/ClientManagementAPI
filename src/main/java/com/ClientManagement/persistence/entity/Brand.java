package com.ClientManagement.persistence.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brand")
    private Integer idbrand;

    private String brand;

    public Integer getIdbrand() {
        return idbrand;
    }

    public void setIdbrand(Integer idbrand) {
        this.idbrand = idbrand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
