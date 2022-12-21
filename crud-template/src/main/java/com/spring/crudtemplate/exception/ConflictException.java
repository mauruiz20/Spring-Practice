package com.spring.crudtemplate.exception;

public class ConflictException extends RuntimeException {
    public ConflictException(String detail) {

        super(detail);
    }

}
