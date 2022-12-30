package com.ClientManagement.domain.dto;

import com.ClientManagement.domain.Brand;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class CustomerDTO {

    private int idCustomerDTO;
    private Brand brandDTO;
    private int dniDTO;
    private String nameDTO;
    private String lastNameDTO;
    private int ageDTO;
    private String phoneDTO;
    private String emailDTO;

    public CustomerDTO(int idCustomerDTO, Brand brandDTO, int dniDTO, String nameDTO, String lastNameDTO, int ageDTO, String phoneDTO, String emailDTO) {
        this.idCustomerDTO = idCustomerDTO;
        this.brandDTO = brandDTO;
        this.dniDTO = dniDTO;
        this.nameDTO = nameDTO;
        this.lastNameDTO = lastNameDTO;
        this.ageDTO = ageDTO;
        this.phoneDTO = phoneDTO;
        this.emailDTO = emailDTO;
    }

    public int getIdCustomerDTO() {
        return idCustomerDTO;
    }

    public void setIdCustomerDTO(int idCustomerDTO) {
        this.idCustomerDTO = idCustomerDTO;
    }

    public Brand getBrandDTO() {
        return brandDTO;
    }

    public void setBrandDTO(Brand brandDTO) {
        this.brandDTO = brandDTO;
    }

    public int getDniDTO() {
        return dniDTO;
    }

    public void setDniDTO(int dniDTO) {
        this.dniDTO = dniDTO;
    }

    public String getNameDTO() {
        return nameDTO;
    }

    public void setNameDTO(String nameDTO) {
        this.nameDTO = nameDTO;
    }

    public String getLastNameDTO() {
        return lastNameDTO;
    }

    public void setLastNameDTO(String lastNameDTO) {
        this.lastNameDTO = lastNameDTO;
    }

    public int getAgeDTO() {
        return ageDTO;
    }

    public void setAgeDTO(int ageDTO) {
        this.ageDTO = ageDTO;
    }

    public String getPhoneDTO() {
        return phoneDTO;
    }

    public void setPhoneDTO(String phoneDTO) {
        this.phoneDTO = phoneDTO;
    }

    public String getEmailDTO() {
        return emailDTO;
    }

    public void setEmailDTO(String emailDTO) {
        this.emailDTO = emailDTO;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "idCustomerDTO=" + idCustomerDTO +
                ", brandDTO=" + brandDTO +
                ", dniDTO=" + dniDTO +
                ", nameDTO='" + nameDTO + '\'' +
                ", lastNameDTO='" + lastNameDTO + '\'' +
                ", ageDTO=" + ageDTO +
                ", phoneDTO='" + phoneDTO + '\'' +
                ", emailDTO='" + emailDTO + '\'' +
                '}';
    }
}
