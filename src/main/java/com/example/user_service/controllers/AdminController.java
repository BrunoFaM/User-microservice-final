package com.example.user_service.controllers;

import com.example.user_service.dtos.NewUser;
import com.example.user_service.dtos.UserDTO;
import com.example.user_service.exceptions.EmailAlredyregisterException;
import com.example.user_service.models.RolType;
import com.example.user_service.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){

        List<UserDTO> users = userService.getUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<?> getAllUsersRoles(){
        List<RolType> rolTypes = userService.getAllRoles();

        return new ResponseEntity<>(rolTypes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postUser(@Valid @RequestBody NewUser newUser) throws EmailAlredyregisterException {

        UserDTO userDTO = userService.createUser(newUser);

        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
}
