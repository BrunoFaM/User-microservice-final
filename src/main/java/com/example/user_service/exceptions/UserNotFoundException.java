package com.example.user_service.exceptions;

public class UserNotFoundException extends Exception {
  private static final String message = "User Not found";

    public UserNotFoundException() {
        super(message);
    }
}
