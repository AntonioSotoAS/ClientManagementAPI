package com.ClientManagement.domain.service;

import com.ClientManagement.domain.Role;
import com.ClientManagement.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAll(){
        return roleRepository.getAll();
    }
    public Optional<List<Role>> getByRole(int roleId){
        return roleRepository.getByRole(roleId);
    }
    public Optional<Role> getRole(int roleId){
        return roleRepository.getRole(roleId);
    }
    public Role save (Role role){
        return roleRepository.save(role);
    }
    public Role update(Role role){
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
