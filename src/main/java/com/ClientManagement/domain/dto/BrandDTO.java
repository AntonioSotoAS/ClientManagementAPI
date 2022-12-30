package com.ClientManagement.domain.dto;

public class BrandDTO {

    private int idBrandDTO;
    private String brandDTO;

    public BrandDTO() {
    }

    public BrandDTO(int idBrandDTO, String brandDTO) {
        this.idBrandDTO = idBrandDTO;
        this.brandDTO = brandDTO;
    }

    public BrandDTO(String brandDTO) {
        this.brandDTO = brandDTO;
    }

    public int getIdBrandDTO() {
        return idBrandDTO;
    }

    public void setIdBrandDTO(int idBrandDTO) {
        this.idBrandDTO = idBrandDTO;
    }

    public String getBrandDTO() {
        return brandDTO;
    }

    public void setBrandDTO(String brandDTO) {
        this.brandDTO = brandDTO;
    }

    @Override
    public String toString() {
        return "BrandDTO{" +
                "idBrandDTO=" + idBrandDTO +
                ", brandDTO='" + brandDTO + '\'' +
                '}';
    }
}
