package com.ClientManagement.domain.dto;

public class RoleDTO {

    private int idRole;
    private String roleType;

    public RoleDTO(String roleType) {
        this.roleType = roleType;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "idRole=" + idRole +
                ", roleType='" + roleType + '\'' +
                '}';
    }
}
