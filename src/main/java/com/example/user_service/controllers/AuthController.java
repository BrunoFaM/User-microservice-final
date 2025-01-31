package com.example.user_service.controllers;

import com.example.user_service.config.JwtUtils;
import com.example.user_service.dtos.LoginRequest;
import com.example.user_service.dtos.NewUser;
import com.example.user_service.dtos.UserDTO;
import com.example.user_service.exceptions.EmailAlredyregisterException;
import com.example.user_service.exceptions.UserNotFoundException;
import com.example.user_service.models.UserEntity;
import com.example.user_service.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @Operation(summary = "log in", description = "return a JWT token if the user exists")
    public ResponseEntity<String> authenticateUser(@RequestBody @Valid LoginRequest loginRequest) throws UserNotFoundException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.email(),
                        loginRequest.password()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserEntity user = userService.getUserByEmail(authentication.getName());
        String jwt = jwtUtil.createToken(authentication.getName(), user.getRole(), user.getId());
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/register")
    @Transactional
    @Operation(summary = "Register a user", description = "Create a user with Role of user")
    public ResponseEntity<?> registerUser(@RequestBody @Valid NewUser newUser) throws EmailAlredyregisterException {
        UserDTO user = userService.createUser(newUser);

        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }
}
