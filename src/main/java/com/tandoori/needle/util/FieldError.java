package com.tandoori.needle.util;

import lombok.Data;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Data
public class FieldError {

    private final String fieldName;
    private final String message;

    public static List<FieldError> getFieldErrors(Set<ConstraintViolation<?>> constraintViolations) {

        return constraintViolations.stream()
                .map(FieldError::toFieldError).collect(Collectors.toList());
    }

    private static FieldError toFieldError(ConstraintViolation<?> constraintViolation) {

        String propertyPath =
                constraintViolation.getPropertyPath().toString();

        String field = propertyPath.substring(propertyPath.lastIndexOf('.') + 1);

        return new FieldError(field, constraintViolation.getMessage());

    }


}


