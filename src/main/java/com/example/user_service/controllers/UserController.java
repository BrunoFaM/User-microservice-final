package com.example.user_service.controllers;

import com.example.user_service.dtos.NewUser;
import com.example.user_service.dtos.UserDTO;
import com.example.user_service.exceptions.EmailAlredyregisterException;
import com.example.user_service.exceptions.UserNotFoundException;
import com.example.user_service.models.RolType;
import com.example.user_service.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getCurrentUserData(HttpServletRequest request) throws UserNotFoundException {
        UserDTO user = userService.getUserData(request);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }



}
