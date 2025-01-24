package com.example.user_service.controllers;

import com.example.user_service.dtos.NewUser;
import com.example.user_service.dtos.UserDTO;
import com.example.user_service.exceptions.UserNotFoundException;
import com.example.user_service.models.RolType;
import com.example.user_service.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){

        List<UserDTO> users = userService.getUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{email}")
    public ResponseEntity<?> getUserIdByEmail(@PathVariable String email) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserIdByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<?> getAllUsersRoles(){
        List<RolType> rolTypes = userService.getAllRoles();

        return new ResponseEntity<>(rolTypes, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> postUser(@Valid @RequestBody NewUser newUser){

        UserDTO userDTO = userService.createUser(newUser);

        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }


}
