package com.example.user_service.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record NewUser(@NotBlank(message = "Can't be blank") String username,@NotBlank(message = "Can't be blank") @Email(message = "Has to be a valid email") String email, @NotBlank(message = "Can't be blank") String password) {
}
