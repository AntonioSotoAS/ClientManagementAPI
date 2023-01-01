package com.ClientManagement.domain.dto;

public class RoleDTO {

    private int idRoleDTO;
    private String roleTypeDTO;

    public RoleDTO(int idRoleDTO, String roleTypeDTO) {
        this.idRoleDTO = idRoleDTO;
        this.roleTypeDTO = roleTypeDTO;
    }

    public int getIdRoleDTO() {
        return idRoleDTO;
    }

    public void setIdRoleDTO(int idRoleDTO) {
        this.idRoleDTO = idRoleDTO;
    }

    public String getRoleTypeDTO() {
        return roleTypeDTO;
    }

    public void setRoleTypeDTO(String roleTypeDTO) {
        this.roleTypeDTO = roleTypeDTO;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "idRoleDTO=" + idRoleDTO +
                ", roleTypeDTO='" + roleTypeDTO + '\'' +
                '}';
    }
}
