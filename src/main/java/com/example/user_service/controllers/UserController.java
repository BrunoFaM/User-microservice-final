package com.example.user_service.controllers;

import com.example.user_service.dtos.UserDTO;
import com.example.user_service.models.RolType;
import com.example.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){

        Set<UserDTO> users = userService.getUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<?> getAllUsersRoles(){
        Set<RolType> rolTypes = userService.getAllRoles();

        return new ResponseEntity<>(rolTypes, HttpStatus.OK);
    }

//    @PostMapping("/users")
//    public ResponseEntity<?> postUser(){
//
//        userService.createUser();
//
//
//    }


}
