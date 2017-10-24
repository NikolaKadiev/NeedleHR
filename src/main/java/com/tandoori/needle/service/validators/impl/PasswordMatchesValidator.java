package com.tandoori.needle.service.validators.impl;

import com.tandoori.needle.service.validators.PasswordMatches;
import com.tandoori.needle.web.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserDTO> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext context) {
        return userDTO.getPassword().equals(userDTO.getMatchingPassword());
    }
}
