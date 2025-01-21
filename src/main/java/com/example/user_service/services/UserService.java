package com.example.user_service.services;

import com.example.user_service.dtos.UserDTO;
import com.example.user_service.models.RolType;
import com.example.user_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    Set<UserDTO> getUsers();

    void createUser(UserDTO userDTO);

    Set<RolType> getAllRoles();
}
