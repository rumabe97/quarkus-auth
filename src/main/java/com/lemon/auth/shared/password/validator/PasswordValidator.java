package com.lemon.auth.shared.password.validator;


import com.lemon.auth.content.user.adapter.rest.dto.in.UserInDto;
import com.lemon.auth.shared.password.PasswordValidations;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator extends PasswordValidations implements ConstraintValidator<ValidationUserDto, UserInDto> {

    @Override
    public boolean isValid(UserInDto userInDto, ConstraintValidatorContext constraintValidatorContext) {
        return super.isValid(userInDto.getPassword());
    }
}