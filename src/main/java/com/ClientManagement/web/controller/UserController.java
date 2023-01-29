package com.ClientManagement.web.controller;


import com.ClientManagement.domain.dto.UserDTO;
import com.ClientManagement.domain.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ApiOperation("Get All User")
    public ResponseEntity<List<UserDTO>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a User with an ID")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404,message = "User not found")

    })
    public ResponseEntity<UserDTO> getUser(@ApiParam(value = "The id of the User"
            ,required = true,example = "2")@PathVariable("id") int userId){
        return userService.getUser(userId).map(user -> new ResponseEntity<>(user,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save User")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO user){

        return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete User")
    public ResponseEntity delete(@PathVariable("id") int userId){

        if (userService.delete(userId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    @ApiOperation("Update User")
    public UserDTO update(@RequestBody UserDTO user){
        return userService.update(user);
    }

}
