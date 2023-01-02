package com.ClientManagement.domain.service;

import com.ClientManagement.domain.Role;
import com.ClientManagement.domain.dto.RoleDTO;
import com.ClientManagement.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<RoleDTO> getAll(){
        return roleRepository.getAll();
    }
    public Optional<RoleDTO> getRole(int roleId){
        return roleRepository.getRole(roleId);
    }
    public RoleDTO save (RoleDTO role){
        return roleRepository.save(role);
    }
    public RoleDTO update(RoleDTO role){
        return roleRepository.update(role);
    }
    public boolean delete(int roleId){
        if (getRole(roleId).isPresent()){
            roleRepository.delete(roleId);
            return true;
        }else {
            return false;
        }
    }

}
