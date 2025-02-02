package com.example.user_service.services;

import com.example.user_service.dtos.UserDTO;

public interface MessageSenderService {

    void sendSuccessfulRegisterMessage(UserDTO user);
}
