package com.example.user_service.services;

import com.example.user_service.dtos.NewUser;
import com.example.user_service.dtos.UserDTO;
import com.example.user_service.exceptions.UserNotFoundException;
import com.example.user_service.models.RolType;
import com.example.user_service.models.UserEntity;


import java.util.List;
import java.util.Set;

public interface UserService {

    List<UserDTO> getUsers();

    UserEntity getUserByEmail(String email) throws UserNotFoundException;

    UserDTO createUser(NewUser newUser);

    List<RolType> getAllRoles();

    Long getUserIdByEmail(String email) throws UserNotFoundException;
}
