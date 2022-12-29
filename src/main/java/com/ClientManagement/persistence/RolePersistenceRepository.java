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
    private RoleMapper mapper;

    @Override
    public List<RoleDTO> getAll() {
        return mapper.toRoleDTOs((List<Role>) roleCrudRepository.findAll());
    }

    @Override
    public Optional<List<RoleDTO>> getByRole(int roleId) {
        return roleCrudRepository.findAllByIdRole(roleId)
                .map(roles -> mapper.toRoleDTOs(roles));
    }

    @Override
    public Optional<RoleDTO> getRole(int roleId) {
        return roleCrudRepository.findById(roleId)
                .map(role -> mapper.toRoleDTO(role));
    }

    @Override
    public RoleDTO save(RoleDTO role) {
        Role roleEntity = mapper.toRole(role);

        return mapper.toRoleDTO(roleCrudRepository.save(roleEntity));
    }

    @Override
    public RoleDTO update(RoleDTO role) {
        return getRole(role.getIdRoleDTO())
                .map(roletoUpdate -> {
                    roletoUpdate.setRoleTypeDTO(role.getRoleTypeDTO());
                    Role roleEntity = mapper.toRole(roletoUpdate);
                    return save(mapper.toRoleDTO(roleEntity));
                }).orElse(null);
    }

    @Override
    public void delete(int roleId) {
        roleCrudRepository.deleteById(roleId);
    }
}
