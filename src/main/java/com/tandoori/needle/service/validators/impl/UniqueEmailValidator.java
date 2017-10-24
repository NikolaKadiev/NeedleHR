package com.tandoori.needle.service.validators.impl;

import com.tandoori.needle.repository.UserAccountRepository;
import com.tandoori.needle.service.validators.UniqueEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userAccountRepository.findByEmail(email) == null ? true : false;
    }
}
