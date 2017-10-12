package com.tandoori.needle.exception.handler;

import com.tandoori.needle.exception.ApiException;
import com.tandoori.needle.util.FieldError;
import com.tandoori.needle.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handleApiException(ApiException e) {

        return new ResponseEntity<>(new ApiError(e.getStatusCode(), e.getDescription()),
                HttpStatus.valueOf(e.getStatusCode()));
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    ResponseEntity<ApiError> handleValidationError(ConstraintViolationException e) {

        String validationErrors = FieldError.getFieldErrors(e.getConstraintViolations())
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST.value(), validationErrors),
                HttpStatus.BAD_REQUEST);
    }
}
