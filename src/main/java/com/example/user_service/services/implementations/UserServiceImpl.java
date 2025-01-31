package com.example.user_service.services.implementations;

import com.example.user_service.dtos.NewUser;
import com.example.user_service.dtos.UserDTO;
import com.example.user_service.exceptions.EmailAlredyregisterException;
import com.example.user_service.exceptions.UserNotFoundException;
import com.example.user_service.models.RolType;
import com.example.user_service.models.UserEntity;
import com.example.user_service.repositories.UserRepository;
import com.example.user_service.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<UserDTO> getUsers() {
        List<UserEntity> usersList = userRepository.findAll();

        List<UserDTO> users = usersList
                .stream()
                .map(UserDTO::new)
                .toList();

        return users;
    }

    @Override
    public UserDTO createUser(NewUser newUser) throws EmailAlredyregisterException {
        validateNewUser(newUser);
        UserEntity user = new UserEntity(newUser.username(), newUser.email(), passwordEncoder.encode(newUser.password()));
        userRepository.save(user);
        // async call to email
        UserDTO createdUser = new UserDTO(user);

        amqpTemplate.convertAndSend("userMailExchange", "email.key", createdUser);

        return new UserDTO(user);
    }

    private void validateNewUser(NewUser newUser) throws EmailAlredyregisterException {
        if(userRepository.existsByEmail(newUser.email())){
            throw new EmailAlredyregisterException();
        }
    }

    @Override
    public List<RolType> getAllRoles() {

        List<RolType> roles = userRepository.findAll()
                .stream()
                .map(userEntity -> userEntity.getRole())
                .toList();
        return roles;
    }

    @Override
    public UserEntity getUserByEmail(String email) throws UserNotFoundException {

        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());

    }

    @Override
    public Long getUserIdByEmail(String email) throws UserNotFoundException {
        UserEntity user = getUserByEmail(email);
        return user.getId();
    }
}
