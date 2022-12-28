package com.ClientManagement.domain;

public class ClientPorfolio {

    private int idClientPorfolio;
    private Customer customer;

    public ClientPorfolio(Customer customer) {
        this.customer = customer;
    }

    public int getIdClientPorfolio() {
        return idClientPorfolio;
    }

    public void setIdClientPorfolio(int idClientPorfolio) {
        this.idClientPorfolio = idClientPorfolio;
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
                ", customer=" + customer +
                '}';
    }
}
