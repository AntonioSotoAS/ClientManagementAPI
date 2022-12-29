package com.ClientManagement.domain.dto;

import com.ClientManagement.domain.Brand;

import java.util.Arrays;

public class CustomerDTO {

    private int idCustomer;
    private Brand brand;
    private int dni;
    private String name;
    private String lastName;
    private int age;
    private String phone;
    private String email;
    private byte[] photo;

    public CustomerDTO(Brand brand, int dni, String name, String lastName, int age, String phone, String email, byte[] photo) {
        this.brand = brand;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "idCustomer=" + idCustomer +
                ", brand=" + brand +
                ", dni=" + dni +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
