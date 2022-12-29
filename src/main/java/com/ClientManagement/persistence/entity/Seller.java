package com.ClientManagement.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seller")
    private Integer idSeller;

    @OneToOne
    @JoinColumn(name = "id_client_profolio")
    private ClientPorfolio clientPorfolio;

    private Integer dni;

    private String name;
    @Column(name = "last_name")
    private String lastName;
    private byte[] photo;

    public Integer getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(Integer idSeller) {
        this.idSeller = idSeller;
    }

    public ClientPorfolio getClientPorfolio() {
        return clientPorfolio;
    }

    public void setClientPorfolio(ClientPorfolio clientPorfolio) {
        this.clientPorfolio = clientPorfolio;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
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
}
