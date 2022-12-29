package com.ClientManagement.domain.repository;

import com.ClientManagement.domain.Role;
import com.ClientManagement.domain.dto.RoleDTO;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {

    List<RoleDTO> getAll();
    Optional<List<RoleDTO>> getByRole(int roleId);
    Optional<RoleDTO> getRole(int roleId);
    RoleDTO save (RoleDTO role);
    RoleDTO update(RoleDTO role);
    void delete(int roleId);

}
