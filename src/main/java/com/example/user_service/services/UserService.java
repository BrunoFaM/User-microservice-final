package com.example.user_service.services;

import com.example.user_service.dtos.NewUser;
import com.example.user_service.dtos.UserDTO;
import com.example.user_service.models.RolType;


import java.util.List;
import java.util.Set;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO createUser(NewUser newUser);

    List<RolType> getAllRoles();
}
