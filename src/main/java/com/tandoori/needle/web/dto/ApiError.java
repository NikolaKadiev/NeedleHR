package com.tandoori.needle.web.dto;

import lombok.Data;

@Data
public class ApiError {

    private final int status;
    private final String message;
}
