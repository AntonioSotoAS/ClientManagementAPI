package com.ClientManagement.domain;

public class Role {

    private int idRole;
    private String roleType;

    public Role(String roleType) {
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
        return "Role{" +
                "idRole=" + idRole +
                ", roleType='" + roleType + '\'' +
                '}';
    }
}
