package com.ClientManagement.domain.dto;

import com.ClientManagement.domain.Role;

public class UserDTO {

    private int idUserDTO;
    private RoleDTO roleDTO;
    private SellerDTO sellerUserDTO;
    private String usernameDTO;
    private String passwordDTO;

    public UserDTO(int idUserDTO, RoleDTO roleDTO, SellerDTO sellerUserDTO, String usernameDTO, String passwordDTO) {
        this.idUserDTO = idUserDTO;
        this.roleDTO = roleDTO;
        this.sellerUserDTO = sellerUserDTO;
        this.usernameDTO = usernameDTO;
        this.passwordDTO = passwordDTO;
    }

    public int getIdUserDTO() {
        return idUserDTO;
    }

    public void setIdUserDTO(int idUserDTO) {
        this.idUserDTO = idUserDTO;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    public SellerDTO getSellerUserDTO() {
        return sellerUserDTO;
    }

    public void setSellerUserDTO(SellerDTO sellerUserDTO) {
        this.sellerUserDTO = sellerUserDTO;
    }

    public String getUsernameDTO() {
        return usernameDTO;
    }

    public void setUsernameDTO(String usernameDTO) {
        this.usernameDTO = usernameDTO;
    }

    public String getPasswordDTO() {
        return passwordDTO;
    }

    public void setPasswordDTO(String passwordDTO) {
        this.passwordDTO = passwordDTO;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "idUserDTO=" + idUserDTO +
                ", roleDTO=" + roleDTO +
                ", sellerUserDTO=" + sellerUserDTO +
                ", usernameDTO='" + usernameDTO + '\'' +
                ", passwordDTO='" + passwordDTO + '\'' +
                '}';
    }
}
