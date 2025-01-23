package com.example.user_service.dtos;

import com.example.user_service.models.RolType;
import com.example.user_service.models.UserEntity;

public class UserDTO {

    private final Long id;

    private final String username, email;

    private final RolType role;

    public UserDTO(UserEntity user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public RolType getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
