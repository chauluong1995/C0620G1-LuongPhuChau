package com.sprint1backend.DTO;

// Create by: Mai_HTQ
public class RoleDTO {
    Long idRole;
    String nameRole;

    public RoleDTO(Long idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
