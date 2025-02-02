package com.example.user_service.controllers;

import com.example.user_service.exceptions.UserNotFoundException;
import com.example.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/internal")
public class InternalApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity<?> getUserIdByEmail(@PathVariable String email) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserIdByEmail(email), HttpStatus.OK);
    }
}
