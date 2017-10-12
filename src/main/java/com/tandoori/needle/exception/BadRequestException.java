package com.tandoori.needle.exception;


public class BadRequestException extends ApiException {
    public BadRequestException(int statusCode, String description) {
        super(statusCode, description);
    }
}
