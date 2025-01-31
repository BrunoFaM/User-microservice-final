package com.example.user_service.exceptions;

public class EmailAlredyregisterException extends Exception {
  private static final String message = "This account already exists in the data base";

    public EmailAlredyregisterException() {
        super(message);
    }
}
