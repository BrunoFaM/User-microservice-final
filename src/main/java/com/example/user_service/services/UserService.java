package com.example.user_service.services;

import com.example.user_service.dtos.NewUser;
import com.example.user_service.dtos.UserDTO;
import com.example.user_service.exceptions.EmailAlredyregisterException;
import com.example.user_service.exceptions.UserNotFoundException;
import com.example.user_service.models.RolType;
import com.example.user_service.models.UserEntity;
import jakarta.servlet.http.HttpServletRequest;


import java.util.List;
import java.util.Set;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO getUserData(HttpServletRequest request) throws UserNotFoundException;

    UserEntity getUserByEmail(String email) throws UserNotFoundException;

    UserDTO createUser(NewUser newUser) throws EmailAlredyregisterException;

    List<RolType> getAllRoles();

    Long getUserIdByEmail(String email) throws UserNotFoundException;
}
