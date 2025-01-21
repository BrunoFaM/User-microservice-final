package com.example.user_service.services.implementations;

import com.example.user_service.dtos.UserDTO;
import com.example.user_service.models.RolType;
import com.example.user_service.repositories.UserRepository;
import com.example.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Set<UserDTO> getUsers() {
        return Set.of();
    }

    @Override
    public void createUser(UserDTO userDTO) {

    }

    @Override
    public Set<RolType> getAllRoles() {
        return Set.of();
    }
}
