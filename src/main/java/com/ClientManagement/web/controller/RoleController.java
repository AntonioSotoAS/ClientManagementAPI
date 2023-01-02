package com.ClientManagement.web.controller;

import com.ClientManagement.domain.dto.RoleDTO;
import com.ClientManagement.domain.dto.UserDTO;
import com.ClientManagement.domain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<RoleDTO>> getAll(){
        return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getUser(@PathVariable("id") int roleId){
        return roleService.getRole(roleId).map(role -> new ResponseEntity<>(role,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<RoleDTO> save(@RequestBody RoleDTO role){

        return new ResponseEntity<>(roleService.save(role),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int roleId){

        if (roleService.delete(roleId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    public RoleDTO update(@RequestBody RoleDTO role){
        return roleService.update(role);
    }



}
