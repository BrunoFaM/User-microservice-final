package com.example.user_service.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank(message = "Can't be blank") String email, @NotBlank(message = "Can't be blank") String password) {
}
