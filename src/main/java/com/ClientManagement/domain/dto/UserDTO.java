package com.ClientManagement.domain.dto;

import com.ClientManagement.domain.Role;

public class UserDTO {

    private int idUserDTO;
    private Role roleDTO;
    private String usernameDTO;
    private String passwordDTO;

    public UserDTO(Role roleDTO, String usernameDTO, String passwordDTO) {
        this.roleDTO = roleDTO;
        this.usernameDTO = usernameDTO;
        this.passwordDTO = passwordDTO;
    }

    public int getIdUserDTO() {
        return idUserDTO;
    }

    public void setIdUserDTO(int idUserDTO) {
        this.idUserDTO = idUserDTO;
    }

    public Role getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(Role roleDTO) {
        this.roleDTO = roleDTO;
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
                ", usernameDTO='" + usernameDTO + '\'' +
                ", passwordDTO='" + passwordDTO + '\'' +
                '}';
    }
}
