package com.ClientManagement.domain;

public class ClientPorfolio {

    private int idClientPorfolio;
    private Seller seller;
    private Customer customer;

    public ClientPorfolio(int idClientPorfolio, Seller seller, Customer customer) {
        this.idClientPorfolio = idClientPorfolio;
        this.seller = seller;
        this.customer = customer;
    }

    public int getIdClientPorfolio() {
        return idClientPorfolio;
    }

    public void setIdClientPorfolio(int idClientPorfolio) {
        this.idClientPorfolio = idClientPorfolio;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ClientPorfolio{" +
                "idClientPorfolio=" + idClientPorfolio +
                ", seller=" + seller +
                ", customer=" + customer +
                '}';
    }
}
