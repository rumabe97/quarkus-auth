package com.lemon.auth.shared.password;

import com.lemon.auth.shared.models.Constants;

import java.util.regex.Pattern;

public class PasswordValidations {
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

    public boolean isValid(String password) {
        if(password == null) return false;
        return password.length() >= Constants.MIN_LENGTH &&
                containsUppercase(password) &&
                containsLowercase(password) &&
                containsDigit(password) &&
                containsSpecialCharacter(password);
    }
}
