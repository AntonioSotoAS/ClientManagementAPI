package com.ClientManagement.domain;

public class User {

    private int idUser;
    private Role role;
    private Seller seller;
    private String username;
    private String password;

    public User(int idUser, Role role, Seller seller, String username, String password) {
        this.idUser = idUser;
        this.role = role;
        this.seller = seller;
        this.username = username;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", role=" + role +
                ", seller=" + seller +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
