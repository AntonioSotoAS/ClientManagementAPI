package com.ClientManagement.web.controller;

import com.ClientManagement.domain.dto.RoleDTO;
import com.ClientManagement.domain.dto.UserDTO;
import com.ClientManagement.domain.service.RoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation("Get All Roles")
    public ResponseEntity<List<RoleDTO>> getAll(){
        return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a Role with an ID")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404,message = "Role not found")
    })
    public ResponseEntity<RoleDTO> getUser(@ApiParam(value = "The id of the Role"
            ,required = true,example = "2")@PathVariable("id") int roleId){
        return roleService.getRole(roleId).map(role -> new ResponseEntity<>(role,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save brand")
    public ResponseEntity<RoleDTO> save(@RequestBody RoleDTO role){

        return new ResponseEntity<>(roleService.save(role),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete brand")
    public ResponseEntity delete(@PathVariable("id") int roleId){

        if (roleService.delete(roleId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    @ApiOperation("Update brand")
    public RoleDTO update(@RequestBody RoleDTO role){
        return roleService.update(role);
    }



}
