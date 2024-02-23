package com.lemon.auth.shared.password;


import jakarta.validation.ConstraintViolationException;

import java.util.regex.Pattern;

public class PasswordValidator {

    private static final int MIN_LENGTH = 8;

    public static void validatePassword(String password) {
        if (password.length() < MIN_LENGTH ||
                !containsUppercase(password) ||
                !containsLowercase(password) ||
                !containsDigit(password) ||
                !containsSpecialCharacter(password)) {
            throw new ConstraintViolationException("The password does not meet security requirements", null);
        }
    }

    private static boolean containsUppercase(String s) {
        return Pattern.compile("[A-Z]").matcher(s).find();
    }

    private static boolean containsLowercase(String s) {
        return Pattern.compile("[a-z]").matcher(s).find();
    }

    private static boolean containsDigit(String s) {
        return Pattern.compile("\\d").matcher(s).find();
    }

    private static boolean containsSpecialCharacter(String s) {
        return Pattern.compile("[!@#$%^&*()-_=+\\[\\]{}|;:'\",.<>/?]").matcher(s).find();
    }
}