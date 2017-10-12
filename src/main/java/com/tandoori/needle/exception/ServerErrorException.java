package com.tandoori.needle.exception;

public class ServerErrorException extends ApiException{
    public ServerErrorException(int statusCode, String description) {
        super(statusCode, description);
    }
}
