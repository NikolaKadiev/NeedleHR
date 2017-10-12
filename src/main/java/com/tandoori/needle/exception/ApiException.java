package com.tandoori.needle.exception;

import lombok.Data;

@Data
public class ApiException extends RuntimeException {

    private int statusCode;
    private String description;

    public ApiException(int statusCode, String description) {
        super(description);
        this.statusCode = statusCode;
        this.description = description;
    }

}
