package com.lemon.auth.shared.exception;

public class ChangePasswordException extends Exception {

    public ChangePasswordException(){
        super("The new password has been used before. Please choose a different one");
    }
}
