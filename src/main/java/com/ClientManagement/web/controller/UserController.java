package com.ClientManagement.web.controller;


import com.ClientManagement.domain.dto.UserDTO;
import com.ClientManagement.domain.service.UserService;
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
    public ResponseEntity<List<UserDTO>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") int userId){
        return userService.getUser(userId).map(user -> new ResponseEntity<>(user,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //For now, this list is not necessary for the functionality of the api.
    // Yes, as the project progresses, I don't use it, I better remove it.
    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<UserDTO>> getByUser(@PathVariable("userId") int userId){
        return userService.getByUser(userId).map(user -> new ResponseEntity<>(user,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO user){

        return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int userId){

        if (userService.delete(userId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    public UserDTO update(@RequestBody UserDTO user){
        return userService.update(user);
    }

}
