package com.culinario.application.commons.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) { super(message); }
}
