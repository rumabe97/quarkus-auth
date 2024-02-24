package com.lemon.auth.shared.password.validator;

import com.lemon.auth.shared.password.PasswordValidations;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidatorParam extends PasswordValidations implements ConstraintValidator<ValidationQueryParam, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return super.isValid(password);
    }
}
