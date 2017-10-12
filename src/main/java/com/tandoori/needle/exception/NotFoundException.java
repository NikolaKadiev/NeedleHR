package com.tandoori.needle.exception;

public class NotFoundException extends ApiException{
    public NotFoundException(int statusCode, String description) {
        super(statusCode, description);
    }
}
