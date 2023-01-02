package com.ClientManagement.persistence;

import com.ClientManagement.domain.dto.RoleDTO;
import com.ClientManagement.domain.repository.RoleRepository;
import com.ClientManagement.persistence.crud.RoleCrudRepository;
import com.ClientManagement.persistence.entity.Role;
import com.ClientManagement.persistence.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RolePersistenceRepository implements RoleRepository {

    @Autowired
    private RoleCrudRepository roleCrudRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleDTO> getAll() {
        return roleMapper.toRoleDTOs((List<Role>) roleCrudRepository.findAll());
    }


    @Override
    public Optional<RoleDTO> getRole(int roleId) {
        return roleCrudRepository.findById(roleId)
                .map(role -> roleMapper.toRoleDTO(role));
    }

    @Override
    public RoleDTO save(RoleDTO role) {
        Role roleEntity = roleMapper.toRole(role);

        return roleMapper.toRoleDTO(roleCrudRepository.save(roleEntity));
    }

    @Override
    public RoleDTO update(RoleDTO role) {
        return getRole(role.getIdRoleDTO())
                .map(roletoUpdate -> {
                    roletoUpdate.setRoleTypeDTO(role.getRoleTypeDTO());
                    Role roleEntity = roleMapper.toRole(roletoUpdate);
                    return save(roleMapper.toRoleDTO(roleEntity));
                }).orElse(null);
    }

    @Override
    public void delete(int roleId) {
        roleCrudRepository.deleteById(roleId);
    }
}
